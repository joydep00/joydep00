package com.poca.dating.data.repository

import com.google.firebase.firestore.FirebaseFirestore
import com.poca.dating.data.models.VideoCall, CallStatus, CallHistory
import kotlinx.coroutines.tasks.await

class VideoCallRepository {

    private val firestore = FirebaseFirestore.getInstance()
    private val callsCollection = firestore.collection("video_calls")
    private val callHistoryCollection = firestore.collection("call_history")

    suspend fun initiateCall(videoCall: VideoCall): Result<String> {
        return try {
            val docRef = callsCollection.add(videoCall).await()
            Result.success(docRef.id)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    suspend fun updateCallStatus(callId: String, status: CallStatus): Result<Unit> {
        return try {
            callsCollection.document(callId).update("status", status).await()
            Result.success(Unit)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    suspend fun endCall(callId: String, duration: Long): Result<Unit> {
        return try {
            callsCollection.document(callId).update(
                mapOf(
                    "status" to CallStatus.COMPLETED,
                    "endTime" to System.currentTimeMillis()
                )
            ).await()
            Result.success(Unit)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    suspend fun saveCallHistory(callHistory: CallHistory): Result<Unit> {
        return try {
            callHistoryCollection.add(callHistory).await()
            Result.success(Unit)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    suspend fun getCallHistory(uid: String): Result<List<CallHistory>> {
        return try {
            val history = callHistoryCollection
                .whereIn("userId", listOf(uid))
                .orderBy("callTime", com.google.firebase.firestore.Query.Direction.DESCENDING)
                .limit(50)
                .get()
                .await()
                .toObjects(CallHistory::class.java)
            Result.success(history)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    suspend fun getActiveCall(userId: String): Result<VideoCall?> {
        return try {
            val calls = callsCollection
                .whereEqualTo("receiverId", userId)
                .whereEqualTo("status", CallStatus.RINGING)
                .get()
                .await()
                .toObjects(VideoCall::class.java)
            Result.success(calls.firstOrNull())
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}

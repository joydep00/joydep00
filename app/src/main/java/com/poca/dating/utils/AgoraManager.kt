package com.poca.dating.utils

import android.content.Context
import io.agora.rtc2.Constants
import io.agora.rtc2.IRtcEngineEventHandler
import io.agora.rtc2.RtcEngine
import io.agora.rtc2.RtcEngineConfig
import io.agora.rtc2.video.VideoCanvas

class AgoraManager(private val context: Context) {

    private var rtcEngine: RtcEngine? = null
    private var eventHandler: IRtcEngineEventHandler? = null

    companion object {
        private const val AGORA_APP_ID = "YOUR_AGORA_APP_ID" // Replace with your Agora App ID
    }

    fun initializeEngine(eventHandler: IRtcEngineEventHandler) {
        try {
            this.eventHandler = eventHandler
            val config = RtcEngineConfig()
            config.mContext = context
            config.mAppId = AGORA_APP_ID
            config.mEventHandler = eventHandler
            
            rtcEngine = RtcEngine.create(config)
            rtcEngine?.enableVideo()
            rtcEngine?.enableAudio()
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    fun joinChannel(token: String, channelId: String, uid: Int) {
        rtcEngine?.joinChannel(token, channelId, "", uid)
    }

    fun leaveChannel() {
        rtcEngine?.leaveChannel()
    }

    fun setupLocalVideo(canvas: VideoCanvas) {
        rtcEngine?.setupLocalVideo(canvas)
    }

    fun setupRemoteVideo(canvas: VideoCanvas) {
        rtcEngine?.setupRemoteVideo(canvas)
    }

    fun switchCamera() {
        rtcEngine?.switchCamera()
    }

    fun muteLocalAudio(muted: Boolean) {
        rtcEngine?.muteLocalAudioStream(muted)
    }

    fun muteLocalVideo(muted: Boolean) {
        rtcEngine?.muteLocalVideoStream(muted)
    }

    fun release() {
        rtcEngine?.leaveChannel()
        RtcEngine.destroy()
        rtcEngine = null
    }
}

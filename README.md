# Poca Dating App Clone

একটি সম্পূর্ণ Android ভিডিও কলিং ডেটিং অ্যাপ্লিকেশন।

## ✨ ফিচার

- 🎥 **লাইভ ভিডিও কল** (Agora SDK ব্যবহার করে)
- 👤 **প্রোফাইল ম্যানেজমেন্ট**
- 💬 **রিয়েল-টাইম মেসেজিং**
- 🎯 **স্মার্ট ম্যাচিং সিস্টেম**
- 📍 **লোকেশন-ভিত্তিক ফিচার**
- 💎 **টোকেন/ক্রেডিট সিস্টেম**
- ✅ **ইউজার ভেরিফিকেশন**
- 🎁 **রিওয়ার্ড সিস্টেম**

## 📋 প্রয়োজনীয়তা

- Android Studio Flamingo বা উচ্চতর
- Minimum SDK: 21
- Target SDK: 34
- Kotlin 1.9+

## 🛠 প্রযুক্তি স্ট্যাক

- **Kotlin** - প্রোগ্রামিং ভাষা
- **Firebase** - ব্যাকএন্ড এবং রিয়েল-টাইম ডাটাবেস
- **Agora SDK** - ভিডিও কলিং
- **Jetpack Compose** - UI (ভবিষ্যৎ)
- **Retrofit** - নেটওয়ার্কিং
- **Glide** - ইমেজ লোডিং

## 🚀 শুরু করুন

### 1. Repository Clone করুন

```bash
git clone https://github.com/joydep00/poca-dating-app.git
cd poca-dating-app
```

### 2. Firebase সেটআপ করুন

1. [Firebase Console](https://console.firebase.google.com) এ যান
2. নতুন প্রজেক্ট তৈরি করুন
3. Android অ্যাপ যোগ করুন
4. `google-services.json` ফাইল ডাউনলোড করুন
5. `app/` ফোল্ডারে রাখুন

### 3. Agora সেটআপ করুন

1. [Agora Console](https://console.agora.io) এ যান
2. নতুন প্রজেক্ট তৈরি করুন
3. App ID পান
4. `AgoraManager.kt` ফাইলে আপনার App ID রাখুন:

```kotlin
private const val AGORA_APP_ID = "YOUR_AGORA_APP_ID"
```

### 4. প্রজেক্ট চালান

```bash
./gradlew build
./gradlew installDebug
```

## 📁 প্রজেক্ট স্ট্রাকচার

```
app/src/main/
├── java/com/poca/dating/
│   ├── ui/
│   │   ├── auth/          # লগইন, রেজিস্ট্রেশন
│   │   ├── home/          # হোম স্ক্রিন
│   │   ├── profile/       # প্রোফাইল ম্যানেজমেন্ট
│   │   ├── discover/      # ইউজার ডিসকভার
│   │   ├── videocall/     # ভিডিও কল ইন্টারফেস
│   │   └── chat/          # মেসেজিং
│   ├── data/
│   │   ├── models/        # ডেটা মডেল
│   │   ├── repository/    # রিপোজিটরি প্যাটার্ন
│   │   └── local/         # লোকাল স্টোরেজ
│   ├── utils/
│   │   ├── AgoraManager.kt
│   │   └── Constants.kt
│   └── MainActivity.kt
└── res/
    ├── layout/
    ├── drawable/
    └── values/
```

## 🔑 প্রধান ক্লাস

- **UserRepository** - ইউজার ডেটা ম্যানেজমেন্ট
- **VideoCallRepository** - ভিডিও কল রেকর্ড
- **AgoraManager** - Agora SDK ইন্টিগ্রেশন
- **MainActivity** - মেইন এন্ট্রি পয়েন্ট

## 📝 API Endpoints (ভবিষ্যৎ)

- `POST /auth/register` - নতুন ইউজার রেজিস্ট্রেশন
- `POST /auth/login` - ইউজার লগইন
- `GET /users/nearby` - নিকটবর্তী ইউজার খুঁজুন
- `POST /calls/initiate` - কল শুরু করুন
- `POST /calls/end` - কল শেষ করুন

## 🤝 অবদান রাখুন

1. Fork করুন
2. Feature branch তৈরি করুন (`git checkout -b feature/AmazingFeature`)
3. আপনার পরিবর্তন Commit করুন (`git commit -m 'Add some AmazingFeature'`)
4. Branch এ Push করুন (`git push origin feature/AmazingFeature`)
5. Pull Request খুলুন

## 📄 লাইসেন্স

এই প্রজেক্ট MIT লাইসেন্সের অধীন - বিস্তারিতের জন্য [LICENSE](LICENSE) ফাইল দেখুন।

## 👨‍💻 লেখক

- **Joy Deep** - joydep00

## 📞 সাপোর্ট

যেকোনো সমস্যার জন্য:
- Issues খুলুন
- ডকুমেন্টেশন চেক করুন

---

**Happy Coding! 🚀**

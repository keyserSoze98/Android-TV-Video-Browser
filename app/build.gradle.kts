plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
}

android {
    namespace = "com.keysersoze.androidtvvideobrowser"
    compileSdk {
        version = release(36)
    }

    defaultConfig {
        applicationId = "com.keysersoze.androidtvvideobrowser"
        minSdk = 29
        targetSdk = 36
        versionCode = 1
        versionName = "1.0"

    }

    buildFeatures {
        viewBinding = true
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
}

dependencies {
    // Core AndroidX
    implementation(libs.androidx.core.ktx)
    implementation(libs.appcompat)
    implementation(libs.recyclerview)

    // Leanback (TV UI)
    implementation(libs.androidx.leanback)

    // Lifecycle
    implementation(libs.lifecycle.runtime.ktx)
    implementation(libs.lifecycle.viewmodel.ktx)

    // Coroutines
    implementation(libs.coroutines.core)
    implementation(libs.coroutines.android)

    // ExoPlayer
    implementation(libs.exoplayer.core)

    // Glide for thumbnails
    implementation(libs.glide)
}
plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
    id("com.google.dagger.hilt.android")
}

android {
    compileSdk = 32

    defaultConfig {
        applicationId = "org.sjhstudio.lolchampions"
        minSdk = 24
        targetSdk = 32
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = "1.8"
    }

    dataBinding {
        isEnabled = true
    }

    viewBinding {
        isEnabled = true
    }
}

dependencies {
    implementation(Dependencies.Kotlin.SDK)
    implementation(Dependencies.Kotlin.COROUTINE)

    implementation(Dependencies.KTX.CORE)
    implementation(Dependencies.KTX.VIEWMODEL)
    implementation(Dependencies.KTX.RUNTIME)
    implementation(Dependencies.KTX.ACTIVITY)
    implementation(Dependencies.KTX.FRAGMENT)

    implementation(Dependencies.AndroidX.APPCOMPAT)
    implementation(Dependencies.AndroidX.CONSTRAINT_LAYOUT)

    implementation(Dependencies.Google.MATERIAL)

    implementation(Dependencies.Network.RETROFIT)
    implementation(Dependencies.Network.MOSHI)
    implementation(Dependencies.Network.MOSHI_CONVERTER)
    implementation(Dependencies.Network.OKHTTP)
    implementation(Dependencies.Network.LOGGING_INTERCEPTOR)

    implementation(Dependencies.DI.HILT)
    kapt(Dependencies.DI.HILT_COMPILER)

    implementation(Dependencies.Image.GLIDE)
    annotationProcessor(Dependencies.Image.GLIDE_COMPILER)

    implementation(Dependencies.Custom.CAROUSEL_RECYCLERVIEW)

    testImplementation(Dependencies.Test.JUNIT)
    androidTestImplementation(Dependencies.AndroidTest.EXT)
    androidTestImplementation(Dependencies.AndroidTest.ESPRESSO)
}
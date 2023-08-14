object Dependencies {
    object Kotlin {
        const val SDK = "org.jetbrains.kotlin:kotlin-stdlib-jdk8:1.5.21"
        const val COROUTINE = "org.jetbrains.kotlinx:kotlinx-coroutines-android:1.6.1"
    }

    object AndroidX {
        const val APPCOMPAT = "androidx.appcompat:appcompat:1.4.2"
        const val CONSTRAINT_LAYOUT = "androidx.constraintlayout:constraintlayout:2.1.4"
    }

    object KTX {
        const val CORE = "com.google.android.play:core-ktx:1.8.1"
        const val VIEWMODEL = "androidx.lifecycle:lifecycle-viewmodel-ktx:2.4.0"
        const val RUNTIME = "androidx.lifecycle:lifecycle-runtime-ktx:2.4.0"
        const val ACTIVITY = "androidx.activity:activity-ktx:1.4.0"   // by viewModels()
        const val FRAGMENT = "androidx.fragment:fragment-ktx:1.4.1"   // by activityViewModels()
    }

    object Google {
        const val MATERIAL = "com.google.android.material:material:1.6.1"
    }

    object Network {
        const val RETROFIT = "com.squareup.retrofit2:retrofit:2.9.0"
        const val MOSHI = "com.squareup.moshi:moshi-kotlin:1.9.3"
        const val MOSHI_CONVERTER = "com.squareup.retrofit2:converter-moshi:2.9.0"
        const val OKHTTP = "com.squareup.okhttp3:okhttp:5.0.0-alpha.7"
        const val LOGGING_INTERCEPTOR = "com.squareup.okhttp3:logging-interceptor:5.0.0-alpha.7"
    }

    object DI {
        const val HILT = "com.google.dagger:hilt-android:2.42"
        const val HILT_COMPILER = "com.google.dagger:hilt-android-compiler:2.42"
    }

    object Image {
        const val GLIDE = "com.github.bumptech.glide:glide:4.13.2"
        const val GLIDE_COMPILER = "com.github.bumptech.glide:compiler:4.12.0"
    }

    object Custom {
        const val CAROUSEL_RECYCLERVIEW = "com.github.sparrow007:carouselrecyclerview:1.2.5"
    }

    object Test {
        const val JUNIT = "junit:junit:4.13.2"
    }

    object AndroidTest {
        const val EXT = "androidx.test.ext:junit:1.1.3"
        const val ESPRESSO = "androidx.test.espresso:espresso-core:3.4.0"
    }
}
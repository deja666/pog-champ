plugins {
    id("org.gradle.kotlin.kotlin-dsl") version "2.1.7"
}

repositories {
    google()
    mavenCentral()
}

object PluginVersion {
    const val KOTLIN = "1.7.10"
    const val GRADLE = "7.2.1"
}

dependencies {
    implementation("com.android.tools.build:gradle:${PluginVersion.GRADLE}")
    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:${PluginVersion.KOTLIN}")
    implementation("com.squareup:javapoet:1.13.0")
}
plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.compose.multiplatform)
    alias(libs.plugins.android.library)
    alias(libs.plugins.compose.compiler)
}

kotlin {
    androidTarget()
    jvm()
}

android {
    namespace = "com.goremember.client.localization"
    compileSdk = 35
}
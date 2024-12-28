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
    namespace = "com.goremember.client.core.localization"
    compileSdk = 35
}

dependencies {
    // -- Jetpack Compose --
    commonMainImplementation(platform(libs.compose.bom))
    commonMainImplementation(libs.compose.material3)
    commonMainImplementation(libs.compose.ui.tooling.preview)
    commonMainImplementation(libs.compose.runtime)
    commonMainImplementation(libs.compose.activity)
}
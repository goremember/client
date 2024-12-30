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
    namespace = "com.goremember.client.core.mvi"
    compileSdk = 35

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_19
        targetCompatibility = JavaVersion.VERSION_19
    }
}

dependencies {
    // -- Jetpack Compose --
    commonMainImplementation(platform(libs.compose.bom))
    commonMainImplementation(libs.compose.material3)
    commonMainImplementation(libs.compose.ui.tooling.preview)
    commonMainImplementation(libs.compose.runtime)
    commonMainImplementation(libs.compose.activity)
    // -- FlowMvi --
    commonMainApi(libs.flowmvi.core)
    commonMainApi(libs.flowmvi.compose)
    commonMainApi(libs.flowmvi.essenty)
    commonMainApi(libs.flowmvi.essenty.compose)
    // -- Essenty --
    commonMainApi(libs.essenty.instanceKeeper)
    commonMainApi(libs.essenty.lifecycle)
    // -- Decompose --
    commonMainApi(libs.decompose)
    commonMainApi(libs.decompose.jetbrains.compose)
}
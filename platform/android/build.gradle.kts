plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.compose.compiler)
}

android {
    compileSdk = libs.versions.android.target.get().toInt()

    defaultConfig {
        minSdk = libs.versions.android.min.get().toInt()

        multiDexEnabled = true
    }

    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_19
        targetCompatibility = JavaVersion.VERSION_19
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = true

            proguardFile(
                getDefaultProguardFile("proguard-android-optimize.txt"),
            )
        }
    }

    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = libs.versions.composeCompiler.get()
    }

    namespace = "com.goremember.client"
}

kotlin {
    jvmToolchain(19)
}

dependencies {
    // -- AndroidX --
    implementation(libs.androidx.appcompat)
    // -- Jetpack Compose --
    implementation(platform(libs.compose.bom))
    implementation(libs.compose.material3)
    implementation(libs.compose.ui.tooling.preview)
    implementation(libs.compose.runtime)
    implementation(libs.compose.activity)
    debugImplementation(libs.compose.ui.tooling)
    // -- Modules --
}
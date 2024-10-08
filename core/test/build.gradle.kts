plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
}

android {
    namespace = "pl.inpost.core.test"

    defaultConfig {
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
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
}

dependencies {
    implementation(project(":core:common"))
    api(libs.junit)
    api(libs.kotlinx.coroutines.test)
    api(libs.mockk)
    api(libs.mockk.android)
    api(libs.turbine)

    testImplementation(kotlin("test"))
    androidTestImplementation(kotlin("test"))
}
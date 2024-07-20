plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
}

android {
    namespace = "io.github.subhamtyagi.openinwhatsapp"
    compileSdk = 34

    defaultConfig {
        applicationId = "io.github.subhamtyagi.openinwhatsapp"
        minSdk = 21
        targetSdk = 34
        versionCode = 7
        versionName = "1.4"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = true
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation (libs.material)
    implementation(libs.appcompat)
    implementation(libs.preference)
    implementation(libs.libphonenumber)
    implementation(libs.phonefield)
}
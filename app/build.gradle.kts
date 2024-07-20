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

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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
    buildFeatures {
        compose = true
    }
  //  composeOptions {
   //     kotlinCompilerExtensionVersion = "1.5.1"
  //  }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    //implementation(libs.androidx.activity.compose)
  //  implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
  //  implementation(libs.androidx.ui.graphics)
   // implementation(libs.androidx.ui.tooling.preview)
   // implementation(libs.androidx.material3)
    implementation (libs.material)
    implementation(libs.appcompat)
    implementation(libs.preference)
    implementation(libs.libphonenumber)
    implementation(libs.phonefield)

    implementation(libs.androidx.constraintlayout)

    testImplementation(libs.junit)
   // androidTestImplementation(libs.androidx.junit)
   // androidTestImplementation(libs.androidx.espresso.core)
   // androidTestImplementation(platform(libs.androidx.compose.bom))
  //  androidTestImplementation(libs.androidx.ui.test.junit4)

  //  debugImplementation(libs.androidx.ui.tooling)
   // debugImplementation(libs.androidx.ui.test.manifest)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)

}
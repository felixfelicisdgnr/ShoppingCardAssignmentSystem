plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
    id("org.jetbrains.kotlin.kapt")
    id("com.google.dagger.hilt.android")
    id("com.google.devtools.ksp")

}

android {
    namespace = "com.doga.shoppingcardassignmentsystem"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.doga.shoppingcardassignmentsystem"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }

        compileOptions {
            sourceCompatibility = JavaVersion.VERSION_17
            targetCompatibility = JavaVersion.VERSION_17
        }

        kotlinOptions {
            jvmTarget = "17"
        }

        buildFeatures {
            viewBinding = true
        }
    }

    kapt {
        correctErrorTypes = true
    }

    dependencies {

        implementation(libs.androidx.core.ktx)
        implementation(libs.androidx.appcompat)
        implementation(libs.material)
        implementation(libs.androidx.activity)
        implementation(libs.androidx.constraintlayout)
        testImplementation(libs.junit)
        androidTestImplementation(libs.androidx.junit)
        androidTestImplementation(libs.androidx.espresso.core)

        implementation(libs.google.material)

        // Navigation
        implementation(libs.androidx.navigation.fragment.ktx)
        implementation(libs.androidx.navigation.ui.ktx)

        // Coroutines
        implementation(libs.kotlinx.coroutines.android)
        implementation(libs.kotlinx.coroutines.play.services)


        // Room
        implementation(libs.androidx.room.runtime)
        ksp(libs.androidx.room.compiler)
        implementation(libs.androidx.room.ktx)

        // Hilt
        implementation(libs.hilt.android)
        kapt(libs.hilt.android.compiler)
    }
}


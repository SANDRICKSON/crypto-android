plugins {
    alias(libs.plugins.android.application)
}

android {
    namespace = "com.example.cryptoappxml"
    compileSdk {
        version = release(37)
    }

    defaultConfig {
        applicationId = "com.example.cryptoappxml"
        minSdk = 33
        targetSdk = 37
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            optimization {
                enable = false
            }
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }


    buildFeatures {
        viewBinding = true
    }
}

dependencies {
    implementation(libs.androidx.activity.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.androidx.core.ktx)
    implementation(libs.material)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(libs.androidx.junit)

    // Retrofit
    implementation("com.squareup.retrofit2:retrofit:2.11.0")
    // GSON Converter (JSON-ის ობიექტებად დასაპარსად)
    implementation("com.squareup.retrofit2:converter-gson:2.11.0")

    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.8.5")



    implementation("androidx.activity:activity-ktx:1.9.2")
}
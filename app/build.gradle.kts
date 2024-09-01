plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.example.fitin"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.fitin"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"
        multiDexEnabled = true

        ndk {
            abiFilters += listOf("armeabi-v7a", "arm64-v8a", "x86", "x86_64")
        }

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    packaging{
        jniLibs {
            pickFirsts += listOf(
                "lib/x86_64/libjsc.so",
                "lib/arm64-v8a/libjsc.so",
                "lib/x86/libc++_shared.so",
                "lib/arm64-v8a/libc++_shared.so",
                "lib/x86_64/libc++_shared.so",
                "lib/armeabi-v7a/libc++_shared.so"
            )
        }
        resources {
            excludes += listOf(
                "**/module-info.class",
                "META-INF/DEPENDENCIES.txt",
                "META-INF/LICENSE.txt",
                "META-INF/NOTICE.txt",
                "META-INF/NOTICE",
                "META-INF/LICENSE",
                "META-INF/DEPENDENCIES",
                "META-INF/notice.txt",
                "META-INF/license.txt",
                "META-INF/dependencies.txt",
                "META-INF/LGPL2.1",
                "META-INF/ASL2.0",
                "META-INF/*.kotlin_module"
            )
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = true
            isDebuggable = false
            isShrinkResources = true
            proguardFile("proguard-rules.pro")
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
            lint{
                lint.abortOnError = false
                lint.checkReleaseBuilds = false
                lint.warningsAsErrors = false
                lint.disable += "UnusedResources"
                lint.disable += "MissingTranslation"
            }
        }

        debug {
            isMinifyEnabled = false
            isDebuggable = true
            isShrinkResources = false
            proguardFile("proguard-rules.pro")
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
            lint{
                lint.abortOnError = false
                lint.checkReleaseBuilds = false
                lint.warningsAsErrors = false
                lint.disable += "UnusedResources"
                lint.disable += "MissingTranslation"
            }
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
        viewBinding = true
    }
}

dependencies {

    implementation("androidx.core:core-ktx:1.13.1")
    implementation("androidx.appcompat:appcompat:1.7.0")
    implementation("com.google.android.material:material:1.12.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.8.3")
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.8.3")
    implementation("androidx.navigation:navigation-fragment-ktx:2.7.7")
    implementation("androidx.navigation:navigation-ui-ktx:2.7.7")
    implementation("androidx.legacy:legacy-support-v4:1.0.0")
    implementation("androidx.fragment:fragment-ktx:1.5.6")
    implementation("androidx.multidex:multidex:2.0.1")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.2.1")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.6.1")

    // Library for Data Scrolling
    implementation ("com.airbnb.android:epoxy:4.6.3")

    //image loading library
    implementation ("com.github.bumptech.glide:glide:4.16.0")

    //circle image
    implementation ("de.hdodenhof:circleimageview:3.1.0")

    
}
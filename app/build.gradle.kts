plugins {
    alias(libs.plugins.android.application)
}

android {
    namespace = "com.example.listycity"
    compileSdk = 36

    defaultConfig {
        applicationId = "com.example.listycity"
        minSdk = 24
        targetSdk = 36
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
    }

    compileOptions {
        // Java 11 is fine for this lab
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

    // Keep this minimal; some AGP versions don't resolve the lambda type here.
    // We'll enforce JUnit 5 in the global tasks block below.
    testOptions {
        unitTests.isReturnDefaultValues = true
        // If your IDE resolves it, you can leave this on; otherwise it's harmless to keep.
        // unitTests.all { it.useJUnitPlatform() }
    }
}

// This is the reliable, Kotlin-DSL safe way to enable JUnit 5 for all unit test tasks.
tasks.withType<org.gradle.api.tasks.testing.Test>().configureEach {
    useJUnitPlatform()
}

dependencies {
    // Use modern JUnit 5 and remove JUnit 4 to avoid engine clashes.
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.10.2")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.10.2")

    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.activity)
    implementation(libs.constraintlayout)


    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)
}

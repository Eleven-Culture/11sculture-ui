plugins {
    alias(libs.plugins.android.application)
}

android {
    namespace = "culture.catalog.android"
    compileSdk = 36

    defaultConfig {
        applicationId = "culture.catalog.android"
        minSdk = 24
        targetSdk = 36
        versionCode = 1
        versionName = "1.0"
    }
}

dependencies {
    implementation(project(":catalog"))
    // The AGP 9 KMP library publishes the catalog Activity's manifest entries,
    // but the application host must carry its Android runtime dependencies.
    implementation(libs.androidx.activity.compose)
}

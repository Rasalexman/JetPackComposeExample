plugins {
    id("com.android.application")
    kotlin("android")
    id("kotlin-parcelize")
}

android {
    compileSdk = config.Builds.COMPILE_VERSION
    buildToolsVersion = config.Builds.BUILD_TOOLS
    defaultConfig {
        applicationId = config.Builds.APP_ID
        minSdk = config.Builds.MIN_VERSION
        targetSdk = config.Builds.TARGET_VERSION
        versionCode = config.Builds.App.VERSION_CODE
        versionName = config.Builds.App.VERSION_NAME
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

    // Declare the task that will monitor all configurations.
    configurations.all {
        // 2 Define the resolution strategy in case of conflicts.
        resolutionStrategy {
            // Fail eagerly on version conflict (includes transitive dependencies),
            // e.g., multiple different versions of the same dependency (group and name are equal).
            failOnVersionConflict()

            // Prefer modules that are part of this build (multi-project or composite build) over external modules.
            preferProjectModules()
        }
    }

    /*sourceSets {
        getByName("main") {
            java.setSrcDirs(config.Builds.codeDirs)
            res.setSrcDirs(config.Builds.resDirs)
        }
    }*/

    /*buildFeatures {
        dataBinding = true
    }*/

    buildFeatures {
        // Enables Jetpack Compose for this module
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = config.Versions.compose
        kotlinCompilerVersion = config.Versions.kotlin
    }
    packagingOptions {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }

    kotlinOptions {
        languageVersion = "1.5"
        apiVersion = "1.5"
    }
}

dependencies {
    implementation(project(":shared"))
    implementation(config.Libs.Common.sresult)
    //implementation(config.Libs.Common.sresultpresentation)

    implementation("androidx.core:core-ktx:1.6.0")
    implementation("com.google.android.material:material:1.4.0")
    // Integration with activities
    implementation("androidx.activity:activity-compose:1.3.0")

    implementation("androidx.navigation:navigation-compose:2.4.0-alpha05")

    //------ Compose Core
    implementation("androidx.compose.ui:ui:${config.Versions.compose}")
    // Tooling support (Previews, etc.)
    implementation("androidx.compose.ui:ui-tooling:${config.Versions.compose}")
    implementation("androidx.compose.ui:ui-tooling-preview:${config.Versions.compose}")
    // Foundation (Border, Background, Box, Image, Scroll, shapes, animations, etc.)
    //implementation("androidx.compose.foundation:foundation:1.0.0")
    // Material Design
    implementation("androidx.compose.material:material:${config.Versions.compose}")
    // Material design icons
    //implementation("androidx.compose.material:material-icons-core:1.0.0")
    //implementation("androidx.compose.material:material-icons-extended:1.0.0")
    // Integration with observables
    implementation("androidx.compose.runtime:runtime-livedata:1.0.0")

    debugImplementation(config.Libs.Common.leakCanary)
}


plugins {
  alias(libs.plugins.android.library)
  alias(libs.plugins.jetbrains.kotlin.android)
  id("kotlin-kapt")
}

android {
  namespace = "com.anonymouscorgi.modularization.di.component"
  compileSdk = 35

  defaultConfig {
    minSdk = 24

    testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    consumerProguardFiles("consumer-rules.pro")
  }

  buildTypes {
    release {
      isMinifyEnabled = false
      proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
    }
  }
  compileOptions {
    sourceCompatibility = JavaVersion.VERSION_11
    targetCompatibility = JavaVersion.VERSION_11
  }
  testOptions {
    unitTests {
      isIncludeAndroidResources = true
    }
  }
  kotlinOptions {
    jvmTarget = "11"
  }
}

dependencies {
  implementation(project(":modularization:core"))
  implementation(project(":modularization:component:atommanager:prod"))
  implementation(project(":modularization:component:clock:prod"))
  implementation(project(":modularization:component:system:permissions:prod"))
  implementation(project(":modularization:component:thread:prod"))

  kapt(libs.dagger.compiler)
  implementation(libs.dagger)
  implementation(libs.androidx.core.ktx)
  implementation(libs.androidx.appcompat)
  implementation(libs.material)

  testImplementation(libs.google.truth)
  testImplementation(libs.junit)
  testImplementation(libs.junit.jupiter)
  testImplementation(libs.androidx.espresso.core)
  testImplementation(libs.androidx.core.ktx)
  testImplementation(libs.robolectric)
  testImplementation(libs.mockito.kotlin)

  androidTestImplementation(libs.androidx.junit)
  androidTestImplementation(libs.androidx.espresso.core)
  androidTestImplementation(libs.google.truth)
}
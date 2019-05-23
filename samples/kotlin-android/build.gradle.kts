plugins {
    id("com.android.library") version "3.6.0-rc01"
    kotlin("android") version "1.3.50"
    id("com.yelp.codegen.plugin") version "1.3.0-SNAPSHOT"
}

android {
    compileSdkVersion(28)
    defaultConfig {
        minSdkVersion(21)
        targetSdkVersion(28)
        versionCode = 1
        versionName = "1.0"
    }
}

dependencies {
    // Kotlin
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk7:1.3.50")
    implementation("org.jetbrains.kotlin:kotlin-reflect:1.3.50")

    // Moshi + OkHttp + Retrofit
    implementation("com.squareup.moshi:moshi:1.8.0")
    implementation("com.squareup.moshi:moshi-adapters:1.8.0")
    implementation("com.squareup.moshi:moshi-kotlin:1.8.0")
    implementation("com.squareup.okhttp3:okhttp:3.12.3")
    implementation("com.squareup.retrofit2:retrofit:2.6.1")
    implementation("com.squareup.retrofit2:converter-moshi:2.6.1")
    implementation("com.squareup.retrofit2:adapter-rxjava2:2.6.1")

    // Date Support
    implementation("com.jakewharton.threetenabp:threetenabp:1.2.1")

    // RxJava
    implementation("io.reactivex.rxjava2:rxjava:2.2.11")
    implementation("io.reactivex.rxjava2:rxandroid:2.1.1")
}

generateSwagger {
    platform = "kotlin-coroutines"
    packageName = "com.yelp.codegen.samples"
    specName = "sample_specs"
    specVersion = "1.0.0"
    inputFile = file("../sample_specs.json")
    outputDir = file("./src/main/java/")
    features {
        headersToRemove = arrayOf("Accept-Language")
    }
}

repositories {
    mavenCentral()
}

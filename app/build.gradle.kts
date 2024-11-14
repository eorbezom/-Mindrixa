plugins {
    alias(libs.plugins.androidApplication) // Se usa el plugin de aplicación de Android
}

android {
    namespace = "com.example.mindrixa" // Espacio de nombres del proyecto
    compileSdk = 34 // Versión del SDK de compilación

    defaultConfig {
        applicationId = "com.example.mindrixa" // ID de la aplicación
        minSdk = 24 // SDK mínimo que la aplicación soportará
        targetSdk = 34 // SDK objetivo
        versionCode = 1 // Código de versión
        versionName = "1.0" // Nombre de versión

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner" // Runner para pruebas
    }

    buildTypes {
        release {
            isMinifyEnabled = false // No se minificará en la versión de lanzamiento
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro" // Archivos de configuración de ProGuard
            )
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8 // Compatibilidad con Java 1.8
        targetCompatibility = JavaVersion.VERSION_1_8 // Compatibilidad con Java 1.8
    }
}

dependencies {
    implementation(libs.appcompat) // Dependencia de AppCompat
    implementation(libs.material) // Dependencia de Material Design
    implementation(libs.activity) // Dependencia de actividades
    implementation(libs.constraintlayout) // Dependencia de ConstraintLayout
    testImplementation(libs.junit) // Dependencia para pruebas unitarias
    androidTestImplementation(libs.ext.junit) // Dependencia para pruebas instrumentadas
    androidTestImplementation(libs.espresso.core) // Dependencia para pruebas de UI
    implementation(libs.gson) // Dependencia para Gson

    // Añadir Glide y su compilador
    implementation(libs.glide) // Dependencia de Glide
    annotationProcessor(libs.glide.compiler) // Dependencia para el compilador de Glide



}

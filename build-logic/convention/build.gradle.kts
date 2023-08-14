import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    `kotlin-dsl`
}

group = "com.abudlkarim.jetpackcomposeplayground.buildlogic"

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

tasks.withType<KotlinCompile>().configureEach {
    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_17.toString()
    }
}

dependencies {
    compileOnly(libs.android.gradlePlugin)
    compileOnly(libs.kotlin.gradlePlugin)
}

gradlePlugin{
    plugins {

        register("androidApplication"){
            id = "composeplayground.android.application"
            implementationClass = "AndroidApplicationConventionPlugin"
        }

        register("androidApplicationCompose"){
            id = "composeplayground.android.application.compose"
            implementationClass = "AndroidApplicationComposeConventionPlugin"
        }

        register("AndroidLibrary"){
            id = "composeplayground.android.library"
            implementationClass = "AndroidLibraryConventionPlugin"
        }

        register("AndroidLibraryCompose"){
            id = "composeplayground.android.library.compose"
            implementationClass = "AndroidLibraryComposeConventionPlugin"
        }

    }
}
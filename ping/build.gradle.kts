import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm")
}

group = "org.dronix.os"
version = "1.0-SNAPSHOT"

repositories {
    maven { setUrl("http://dl.bintray.com/kotlin/kotlin-eap") }
    mavenCentral()
}

dependencies {
    api(kotlin("stdlib-jdk8"))
    api(project(":entities"))
    api(project(":domain"))
    api("org.jetbrains.kotlinx:kotlinx-coroutines-core:0.30.1-eap13")

}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}

declareMyJarTask()
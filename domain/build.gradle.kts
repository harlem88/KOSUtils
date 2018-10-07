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
    implementation(kotlin("stdlib-jdk8"))
    api(project(":entities"))
    api("org.jetbrains.kotlinx:kotlinx-coroutines-core:0.30.1-eap13")

    testImplementation("junit:junit:4.12")
    testImplementation("com.willowtreeapps.assertk:assertk:0.10")
    testImplementation("io.mockk:mockk:1.8.8.kotlin13")
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}
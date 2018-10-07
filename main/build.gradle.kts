import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm")
    application
}

group = "org.dronix.os"
version = "1.0-SNAPSHOT"

repositories {
    maven { setUrl("http://dl.bintray.com/kotlin/kotlin-eap") }
    mavenCentral()
}

dependencies {
    compile(kotlin("stdlib-jdk8"))
    api(project(":entities"))
    api(project(":domain"))
    api(project(":kernelinfo"))
}

application {
    mainClassName = "org.dronix.os.tool.main.MainKt"
}
tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}
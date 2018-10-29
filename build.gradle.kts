import groovy.lang.Closure
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

buildscript {

    repositories {
        jcenter()
        maven { setUrl("http://dl.bintray.com/kotlin/kotlin-eap") } // while you are on 1.3-RC
    }

    dependencies {
        classpath("org.jetbrains.kotlin:kotlin-serialization:1.3.0-rc-190")
    }
}

plugins {
    base
    kotlin("jvm") version "1.3.0-rc-190"
}

group = "org.dronix.os"
version = "1.0-SNAPSHOT"

repositories {
    maven { setUrl("http://dl.bintray.com/kotlin/kotlin-eap") }
    maven { setUrl("https://kotlin.bintray.com/kotlinx" )}
    mavenCentral()
}


dependencies {
    compile(kotlin("stdlib-jdk8"))
    compile("org.jetbrains.kotlin:kotlin-reflect:1.3.0-rc-190")
    compile("org.jetbrains.kotlinx:kotlinx-serialization-runtime:0.8.3-rc13")
    compile("com.amazonaws:aws-iot-device-sdk-java:1.2.0")
    compile("org.jetbrains.kotlinx:kotlinx-coroutines-core:0.30.1-eap13")
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}


val libJarTask = declareMyJarTask()

task("allJar") {
    dependsOn(libJarTask.name)
    subprojects.forEach{dependsOn("${it.path}:${it.name}Jar") }
}

task("runApp", Exec::class){
    workingDir = File("./build/New_libs")
    setCommandLine("java -cp \"org.dronix.os-main-1.0-SNAPSHOT.jar:./*\" org.dronix.os.tool.main.MainKt")
}
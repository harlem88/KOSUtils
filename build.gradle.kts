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
    kotlin("jvm") version "1.3.0-rc-190"
}

group = "org.dronix.os"
version = "1.0-SNAPSHOT"

repositories {
    maven { setUrl("http://dl.bintray.com/kotlin/kotlin-eap") }
    mavenCentral()
}

dependencies {
    compile(kotlin("stdlib-jdk8"))
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}
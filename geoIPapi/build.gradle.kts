import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm")
}

apply{
    plugin("kotlinx-serialization")
}

group = "org.dronix.os"
version = "1.0-SNAPSHOT"

repositories {
    maven { setUrl("https://kotlin.bintray.com/kotlinx") }
    maven { setUrl("https://dl.bintray.com/kotlin/kotlin-eap") }
    jcenter()
    mavenCentral()
}

dependencies {
    api(kotlin("stdlib-jdk8"))
    api(project(":entities"))
    api("org.jetbrains.kotlin:kotlin-reflect:1.3.0-rc-190")
    api("org.jetbrains.kotlinx:kotlinx-serialization-runtime:0.8.3-rc13")
    api(project(":domain"))

    testImplementation("junit:junit:4.12")
    testImplementation("com.willowtreeapps.assertk:assertk:0.10")
    testImplementation("io.mockk:mockk:1.8.8.kotlin13")

}



tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}

declareMyJarTask()
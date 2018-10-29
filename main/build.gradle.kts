import org.gradle.internal.impldep.org.apache.commons.io.output.ByteArrayOutputStream
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import org.jetbrains.kotlin.javax.inject.Inject
import org.jetbrains.kotlin.org.jline.utils.InputStreamReader


plugins {
    kotlin("jvm")
    application
}

group = "org.dronix.os"
version = "1.0-SNAPSHOT"

repositories {
    maven { setUrl("http://dl.bintray.com/kotlin/kotlin-eap") }
    maven { setUrl("https://kotlin.bintray.com/kotlinx") }
    mavenCentral()
}

dependencies {
    api(kotlin("stdlib-jdk8"))
    api(project(":entities"))
    api(project(":domain"))
    api(project(":kernelinfo"))
    api(project(":ping"))
    api(project(":geoIPapi"))
}
val mainClass = "org.dronix.os.tool.main.MainKt"

application {
    mainClassName = mainClass
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}

val jar = declareMyJarTask()
jar{
    setMainClass(mainClass)
}

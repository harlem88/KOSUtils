import org.gradle.api.*

import org.gradle.api.file.CopySpec
import org.gradle.api.tasks.*
import org.gradle.api.tasks.bundling.Jar
import org.gradle.kotlin.dsl.*
import java.io.File

open class MyJarTask() : Jar() {

    init {
        description = "Jar a description of $${project.rootProject}-${project.name}."
        baseName = "${project.rootProject.group}-${project.name}"
        destinationDir = File("${project.rootDir}/build/New_libs")

        configureJar()
    }

    @Input
    fun setMainClass(mainClass: String){
        manifest.attributes["Main-Class"] = mainClass
    }

    fun configureJar() {
        configure {

            manifest{
                attributes["Implementation-Version"] = project.version
            }

            from(project.configurations.getByName("runtime")
                .map { file -> if (file.isDirectory) file else project.zipTree(file) }) {
                exclude("META-INF/*.SF" )
                exclude ("META-INF/*.DSA" )
                exclude ("META-INF/*.RSA" )
            }
            with(project.tasks["jar"] as CopySpec)
        }
    }


    fun configureJar2() {
        configure {
        }
    }
}


fun Project.declareMyJarTask() : TaskProvider<MyJarTask> {
    tasks.register<MyJarTask>("${project.name}Jar")
    return tasks.named<MyJarTask>("${project.name}Jar")
}

val Project.myJar: TaskProvider<MyJarTask>
    get() = tasks.named<MyJarTask>("${project.name}Jar")
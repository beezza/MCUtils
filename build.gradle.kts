import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

val mcVersion = "1.19.3"


plugins {
    kotlin("jvm") version "1.7.21"
}

group = "net.beezza.utils"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()

    maven("https://hub.spigotmc.org/nexus/content/repositories/snapshots/")
}

dependencies {
    testImplementation(kotlin("test"))


    compileOnly("org.spigotmc:spigot-api:${mcVersion}-R0.1-SNAPSHOT")
}

tasks.test {
    useJUnitPlatform()
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}

tasks.withType<Jar> {

    duplicatesStrategy = DuplicatesStrategy.EXCLUDE

    manifest {
        attributes["Main-Class"] = "net.beezza.utils.mcutils.MCUtilsKt"
    }

    configurations["compileClasspath"].forEach { file: File ->
        from(zipTree(file.absoluteFile))
    }
}
plugins {
    kotlin("jvm") version "2.0.10"
}

group = "dev.airdead"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

allprojects {
    apply(plugin = "org.jetbrains.kotlin.jvm")

    repositories {
        mavenCentral()
    }
}

kotlin {
    jvmToolchain(17)
}
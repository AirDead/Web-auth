plugins {
    alias(libs.plugins.ktor)
    id("org.jetbrains.kotlin.plugin.serialization") version "1.9.0" // Плагин для сериализации
}

application {
    mainClass.set("dev.airdead.backend.MainKt")

    val isDevelopment: Boolean = project.ext.has("development")
    applicationDefaultJvmArgs = listOf("-Dio.ktor.development=$isDevelopment")
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(libs.ktor.server.core)
    implementation(libs.ktor.server.sessions.jvm)
    implementation(libs.ktor.server.host.common)
    implementation(libs.ktor.server.netty)
    implementation(libs.ktor.server.config.yaml)
    implementation(libs.kotlinx.serialization.json) // Подключение JSON сериализации
    implementation(libs.ktor.serialization.kotlinx.json) // Поддержка Ktor для JSON сериализации
    testImplementation(libs.ktor.server.test.host)
    testImplementation(libs.kotlin.test.junit)
}
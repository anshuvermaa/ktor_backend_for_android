import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    application
    kotlin("jvm") version "1.6.20"
    kotlin("plugin.serialization") version "1.6.20"
}

group = "com.example"
version = "0.0.1"


application{
    mainClass.set("io.ktor.server.netty.EngineMain ")
}

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("stdlib"))

   implementation("io.ktor:ktor-server-core:1.6.4")
   implementation("io.ktor:ktor-server-netty:1.6.4")
   implementation("ch.qos.logback:logback-classic:1.2.6")
    implementation("io.ktor:ktor-serialization:1.6.4")


}


tasks.test {
    useJUnitPlatform()
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}

application {
    mainClass.set("MainKt")
}
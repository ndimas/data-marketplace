plugins {
    id("io.quarkus") version "3.6.3"
    kotlin("jvm") version "1.9.22"
}

repositories {
    mavenCentral()
    mavenLocal()
    maven {
        url = uri("https://plugins.gradle.org/m2/")
    }
}

dependencies {
    implementation(enforcedPlatform("io.quarkus:quarkus-bom:3.6.3"))
    implementation("io.quarkus:quarkus-kotlin")
    implementation("io.quarkus:quarkus-resteasy-reactive-jackson")
    implementation("io.quarkus:quarkus-arc")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    implementation("io.quarkus:quarkus-smallrye-openapi")
    testImplementation("io.quarkus:quarkus-junit5")
    testImplementation("io.rest-assured:rest-assured")
}

group = "com.example"
version = "0.1.0-SNAPSHOT"

java {
    // Your existing java configuration
}
plugins {
    kotlin("jvm") version "2.0.0"
    id("maven-publish")
}

group = "com.github.TonyGnk"
version = "v.0.6.0"

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib"))
    testImplementation("org.jetbrains.kotlin:kotlin-test")
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(17)
}

publishing {
    publications {
        create<MavenPublication>("greeting") {
            from(components["java"])
            groupId = "com.github.TonyGnk"
            artifactId = "multi-objective-lift-scheduler"
            version = "v.0.6.0"
        }
    }
}
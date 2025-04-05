plugins {
    id("java")
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    implementation("jakarta.servlet:jakarta.servlet-api:6.0.0")
    implementation("org.xerial:sqlite-jdbc:3.47.0.0")
}

tasks.test {
    useJUnitPlatform()
}
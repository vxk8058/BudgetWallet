plugins {
    id("java")
    id ("org.springframework.boot") version "3.1.5"
    id ("io.spring.dependency-management") version "1.1.3"
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
    implementation ("com.google.code.gson:gson:2.10.1")
    implementation ("org.springframework.boot:spring-boot-starter-web")
    implementation ("org.springframework.boot:spring-boot-starter-validation")
    implementation ("org.springframework.boot:spring-boot-starter-data-jpa")


}

tasks.test {
    useJUnitPlatform()
}
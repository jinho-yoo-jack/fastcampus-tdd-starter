plugins {
    java
    id("org.springframework.boot") version "3.2.4-SNAPSHOT"
    id("io.spring.dependency-management") version "1.1.4"
}

group = "com.fastcamp"
version = "0.0.1-SNAPSHOT"

java {
    sourceCompatibility = JavaVersion.VERSION_17
}

configurations {
    compileOnly {
        extendsFrom(configurations.annotationProcessor.get())
    }
}

repositories {
    mavenCentral()
    maven { url = uri("https://repo.spring.io/milestone") }
    maven { url = uri("https://repo.spring.io/snapshot") }
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.springframework.boot:spring-boot-starter-web")
    compileOnly("org.projectlombok:lombok")
    developmentOnly("org.springframework.boot:spring-boot-devtools")
    runtimeOnly("com.mysql:mysql-connector-j")
    runtimeOnly("com.oracle.database.jdbc:ojdbc11")
    runtimeOnly("org.postgresql:postgresql")
    annotationProcessor("org.projectlombok:lombok")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    // ArchUnit
    implementation("com.tngtech.archunit:archunit:1.2.1")
    testImplementation("com.tngtech.archunit:archunit-junit5:1.2.1")
    // Mockito
    testImplementation("org.mockito:mockito-core:3.3.0")
    // Chaos-Monkey
    implementation("de.codecentric:chaos-monkey-spring-boot:3.1.0")
    implementation("org.springframework.boot:spring-boot-starter-actuator")

    testImplementation("com.h2database:h2:2.2.224")

}

tasks.withType<Test> {
    useJUnitPlatform()
}

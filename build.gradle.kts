plugins {
	java
	id("org.springframework.boot") version "3.2.2"
	id("io.spring.dependency-management") version "1.1.4"
}

group = "id.ac.ui.cs.advprog"
version = "0.0.1-SNAPSHOT"

java {
	sourceCompatibility = JavaVersion.VERSION_21
}

configurations {
	compileOnly {
		extendsFrom(configurations.annotationProcessor.get())
	}
}

repositories {
	mavenCentral()
}

val seleniumJavaVersion = "4.14.1"
val seleniumJupiterVersion = "5.0.1"
val webdrivermanagerVersion = "5.6.3"
val junitJupiterVersion = "5.9.1"

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-thymeleaf")
	implementation("org.springframework.boot:spring-boot-starter-web")
	compileOnly("org.projectlombok:lombok")
	developmentOnly("org.springframework.boot:spring-boot-devtools")
	annotationProcessor("org.springframework.boot:spring-boot-configuration-processor")
	annotationProcessor("org.projectlombok:lombok")
	implementation("org.springframework.boot:spring-boot-starter-test")
	implementation("org.seleniumhq.selenium:selenium-java:$seleniumJavaVersion")
	implementation("io.github.bonigarcia:webdrivermanager:$webdrivermanagerVersion")
	implementation("org.junit.jupiter:junit-jupiter-api:$junitJupiterVersion")
	implementation("org.junit.jupiter:junit-jupiter-engine:$junitJupiterVersion")
	implementation("io.github.bonigarcia:selenium-jupiter:$seleniumJupiterVersion")
}

tasks.withType<Test> {
	useJUnitPlatform()
}

tasks.register<Test>("unitTest") {
	description = "Run unit tests"
	group = "verification"

	filter {
		excludeTestsMatching("*FunctionalTest")
	}
}

tasks.register<Test>("functionalTest") {
	description = "Run unit tests"
	group = "verification"

	filter {
		includeTestsMatching("*FunctionalTest")
	}
}

tasks.withType<Test>().configureEach {
	useJUnitPlatform()
}
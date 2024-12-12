plugins {
	kotlin("jvm") version libs.versions.kotlinVersion
	kotlin("plugin.spring") version libs.versions.kotlinVersion
	id("org.springframework.boot") version libs.versions.springBoot
	id("io.spring.dependency-management") version "1.1.6"
}

group = "com.weather.processing"
version = "1.0.0-SNAPSHOT"

java {
	toolchain {
		languageVersion = JavaLanguageVersion.of(libs.versions.jvmVersion.get())
	}
}

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-actuator")
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("org.springframework.boot:spring-boot-starter-webflux")
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
	implementation("io.projectreactor.kotlin:reactor-kotlin-extensions")
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	implementation("org.jetbrains.kotlinx:kotlinx-coroutines-reactor")

	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testImplementation("org.springframework.boot:spring-boot-testcontainers")
	testImplementation("io.projectreactor:reactor-test")
	testImplementation("org.jetbrains.kotlin:kotlin-test-junit5")
	testImplementation("org.testcontainers:junit-jupiter")

	testImplementation(libs.kotest.core)
	testImplementation(libs.kotest.assertions)
	testImplementation(libs.kotest.property)
	testImplementation(libs.kotest.datest)

	testRuntimeOnly("org.junit.platform:junit-platform-launcher")


}

kotlin {
	compilerOptions {
		freeCompilerArgs.addAll("-Xjsr305=strict")
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}
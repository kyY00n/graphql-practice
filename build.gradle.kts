plugins {
    kotlin("jvm") version "1.5.10"
    kotlin("plugin.spring") version "1.5.10"
}

group = "com.rosie"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib"))
    implementation("org.springframework.boot:spring-boot-starter-webflux:2.6.4")

    implementation(KotlinX.coroutines.core)
    implementation(KotlinX.coroutines.reactor)

    // graphql
    implementation("com.graphql-java-kickstart:graphql-kickstart-spring-boot-starter-webflux:11.0.0")
    testImplementation("com.graphql-java-kickstart:graphql-spring-boot-starter-test:12.0.0")
    implementation("com.graphql-java-kickstart:graphql-java-tools:11.0.0")
    implementation("com.graphql-java-kickstart:graphql-kickstart-spring-boot-autoconfigure-tools:11.1.0")


    // db
    implementation("com.h2database:h2:2.1.210")
    implementation("io.r2dbc:r2dbc-spi:0.9.1.RELEASE")
    implementation("io.r2dbc:r2dbc-pool:0.9.0.RELEASE")
    runtimeOnly("dev.miku:r2dbc-mysql:0.8.2.RELEASE")
    implementation("org.springframework.data:spring-data-r2dbc:1.4.2")


}
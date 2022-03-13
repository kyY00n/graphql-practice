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

    // graphql
    implementation("com.graphql-java-kickstart:graphql-kickstart-spring-boot-starter-webflux:6.0.0")
    testImplementation("com.graphql-java-kickstart:graphql-spring-boot-starter-test:12.0.0")
    implementation("com.graphql-java-kickstart:graphql-java-tools:12.0.2")
    implementation("com.graphql-java-kickstart:graphql-kickstart-spring-boot-autoconfigure-tools:11.1.0")


    // db
    implementation("com.h2database:h2:2.1.210")
    implementation("io.r2dbc:r2dbc-spi:0.9.1.RELEASE")
    implementation("org.springframework.data:spring-data-r2dbc:1.4.2")


}
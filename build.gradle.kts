group = "to.rxs.kore"

/* A map of versions for consistency over the whole mono repo */
val versions = mapOf(
        /* Flogger */
        "flogger" to "0.5.1",
        "floggerSlf4jBackend" to "0.5.1",

        /* Spring */
        "springCore" to "5.3.3",
        "springContext" to "5.3.3",
        "springBoot" to "2.4.2",
        "springBootAutoConfigure" to "2.4.2",
        "springBootConfigurationProcessor" to "2.4.2",
        "springBootActuator" to "2.4.2",
        "springBootWebFlux" to "5.3.3",
        "springBootStarterWebflux" to "2.4.2",

        /* Jackson */
        "jacksonDatabind" to "2.12.1"
)

/* A map of dependency notations for easier reuse across the mono repo */
mapOf(
        /* Flogger */
        "flogger" to "com.google.flogger:flogger:${versions["flogger"]}",
        "floggerSlf4jBackend" to "com.google.flogger:flogger-slf4j-backend:${versions["floggerSlf4jBackend"]}",

        /* Spring */
        "springCore" to "org.springframework:spring-core:${versions["springCore"]}",
        "springContext" to "org.springframework:spring-context:${versions["springContext"]}",
        "springBoot" to "com.google.flogger:flogger-slf4j-backend:${versions["springBoot"]}",
        "springBootAutoConfigure" to "org.springframework.boot:spring-boot-autoconfigure:${versions["springBootAutoConfigure"]}",
        "springBootConfigurationProcessor" to "org.springframework.boot:spring-boot-configuration-processor:${versions["springBootConfigurationProcessor"]}",
        "springBootActuator" to "org.springframework.boot:spring-boot-actuator-autoconfigure:${versions["springBootActuator"]}",
        "springBootWebFlux" to "org.springframework:spring-webflux:${versions["springBootWebFlux"]}",
        "springBootStarterWebflux" to "org.springframework.boot:spring-boot-starter-webflux:${versions["springBootStarterWebflux"]}",

        /* Jackson */
        "jacksonDatabind" to "com.fasterxml.jackson.core:jackson-databind:${versions["jacksonDatabind"]}"
).forEach { (name, notation) ->
    rootProject.extra.set(name, notation)
}

/* A plugins scope for pre-defining plugin versions */
plugins {
    id("io.freefair.lombok") version "5.3.0" apply false
    id("com.google.cloud.tools.jib") version "2.7.1" apply false
}

/* A project scope for pre-defining the repository handler and the group name */
subprojects {
    repositories {
        mavenCentral()
    }

    group = "${parent?.group}.${parent?.name}"
}

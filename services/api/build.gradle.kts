dependencies {
    val flogger: String by rootProject.extra
    implementation(flogger)

    val floggerSlf4jBackend: String by rootProject.extra
    implementation(floggerSlf4jBackend)

    val springBootStarterWebflux: String by rootProject.extra
    implementation(springBootStarterWebflux)

    val springBootConfigurationProcessor: String by rootProject.extra
    annotationProcessor(springBootConfigurationProcessor)

    val springBootActuator: String by rootProject.extra
    implementation(springBootActuator)

    val springBootAutoConfigure: String by rootProject.extra
    implementation(springBootAutoConfigure)

    implementation(project(":integrations:clients:youtube"))
}

plugins {
    base
    java
    id("io.freefair.lombok")
    id("com.google.cloud.tools.jib")
}

base {
    archivesBaseName = "${group.toString().replace(".", "-")}-$name"
}

java {
    sourceCompatibility = JavaVersion.VERSION_15
}

tasks {
    compileJava {
        options.encoding = "UTF-8"
    }
}

jib {
    from {
        image = "openjdk:15"
    }

    to {
        image = "ghcr.io/rxsto/kore-" + project.name
        tags = setOf(System.getenv("SEMAPHORE_GIT_SHA"))
        auth {
            username = "rxsto"
            password = System.getenv("GITHUB_TOKEN")
        }
    }

    container {
        mainClass = "to.rxs.kore.api.Application"
        jvmFlags = listOf(
                "-Xmx500M",
                "-Xms250M",
                "-XX:+UseG1GC",
                "-XX:+UseStringDeduplication"
        )
    }
}

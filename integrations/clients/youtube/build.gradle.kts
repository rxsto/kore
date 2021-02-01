plugins {
    base
    java
    id("io.freefair.lombok")
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

dependencies {
    val flogger: String by rootProject.extra
    implementation(flogger)

    val floggerSlf4jBackend: String by rootProject.extra
    implementation(floggerSlf4jBackend)

    val springBootWebFlux: String by rootProject.extra
    implementation(springBootWebFlux)

    val jacksonDatabind: String by rootProject.extra
    implementation(jacksonDatabind)
}

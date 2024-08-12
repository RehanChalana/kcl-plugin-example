plugins {
    id("java")
    id("org.jetbrains.kotlin.jvm") version "1.9.24"
    id("org.jetbrains.intellij") version "1.17.3"
}

group =
    "com.rehan"
version =
    "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    // Add other dependencies here if needed

    // Ensure LSP4J is not embedded
//    runtimeOnly("org.eclipse.lsp4j:org.eclipse.lsp4j:0.14.0")
}





// Configure Gradle IntelliJ Plugin
// Read more: https://plugins.jetbrains.com/docs/intellij/tools-gradle-intellij-plugin.html
intellij {
    version.set(
        "2023.2.6"
    )
    type.set(
        "IC"
    ) // Target IDE Platform

    plugins.set(
        listOf("com.redhat.devtools.lsp4ij:0.0.2")
    )
}

tasks {
    // Set the JVM compatibility versions
    withType<JavaCompile> {
        sourceCompatibility =
            "17"
        targetCompatibility =
            "17"
    }
    withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
        kotlinOptions.jvmTarget =
            "17"
    }

    patchPluginXml {
        sinceBuild.set(
            "232"
        )
        untilBuild.set(
            "242.*"
        )
    }

    signPlugin {
        certificateChain.set(
            System.getenv(
                "CERTIFICATE_CHAIN"
            )
        )
        privateKey.set(
            System.getenv(
                "PRIVATE_KEY"
            )
        )
        password.set(
            System.getenv(
                "PRIVATE_KEY_PASSWORD"
            )
        )
    }

    publishPlugin {
        token.set(
            System.getenv(
                "PUBLISH_TOKEN"
            )
        )
    }
}

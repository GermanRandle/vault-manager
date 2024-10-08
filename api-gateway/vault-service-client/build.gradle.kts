import org.jetbrains.gradle.ext.packagePrefix
import org.jetbrains.gradle.ext.settings

val javaVersion = 21
val packageName = "vault.manager.apiGateway.vaultServiceClient"

plugins {
    // Official IDE plugin. In particular, useful for automatic download of source files
    // and Javadoc for project dependencies.
    idea

    // Targeting the JVM.
    alias(libs.plugins.jvm)

    // Extension for IJ IDEA, for avoiding nested packages (in particular).
    alias(libs.plugins.idea.ext)

    // Provides protobuf compilation.
    // https://github.com/google/protobuf-gradle-plugin
    alias(libs.plugins.protobuf)
}

tasks.named<Test>("test") {
    // Use JUnit Platform for unit tests.
    useJUnitPlatform()
}

repositories {
    // Use Maven Central for resolving dependencies.
    mavenCentral()
}

dependencies {
    // Protocol buffers https://github.com/grpc/grpc-kotlin/tree/master/compiler
    api(libs.protobuf.kotlin) // com.google.protobuf.kotlin package
    api(libs.grpc.protobuf) // io.grpc.protobuf package
    api(libs.bundles.grpc.kotlin) // code generation & runtime support
    implementation(libs.grpc.netty) // server

    // JUnit
    testImplementation(libs.bundles.junit)
}

kotlin {
    // With toolchains support, Gradle can autodetect local JDKs
    // and install missing JDKs that Gradle requires for the build.
    jvmToolchain(javaVersion)
}

java {
    toolchain {
        // With toolchains support, Gradle can autodetect local JDKs
        // and install missing JDKs that Gradle requires for the build.
        languageVersion.set(JavaLanguageVersion.of(javaVersion))
    }
}

idea {
    module {
        isDownloadSources = true
        isDownloadJavadoc = true
        settings {
            packagePrefix["src/main/kotlin"] = packageName
            packagePrefix["src/test/kotlin"] = packageName
        }
    }
}

// https://github.com/grpc/grpc-kotlin/tree/master/compiler
protobuf {
    protoc {
        artifact = libs.protoc.get().toString()
    }
    plugins {
        create("grpc") {
            artifact = libs.grpc.java.gen.get().toString()
        }
        create("grpckt") {
            artifact = "${libs.grpc.kotlin.gen.get()}:jdk8@jar"
        }
    }
    generateProtoTasks {
        all().forEach {
            it.plugins {
                create("grpc")
                create("grpckt")
            }
            it.builtins {
                create("kotlin")
            }
        }
    }
}

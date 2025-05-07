plugins {
  alias(libs.plugins.jetbrains.kotlin.jvm)
  id("com.google.protobuf") version "0.9.5"
}

dependencies {
  api(libs.protobuf.javalite)
  api(libs.protobuf.kotlin.lite)
}

protobuf {
  protoc {
    artifact = "com.google.protobuf:protoc:3.25.3"
  }

  // Configure source sets. By default, it looks in src/main/proto
  sourceSets {
    main {
      proto {
        srcDir("src/main/proto")
      }
    }
  }

  generateProtoTasks {
    all().forEach { task ->
      task.builtins {
        maybeCreate("java").option("lite")
        maybeCreate("kotlin").option("lite")
      }
    }
  }
}

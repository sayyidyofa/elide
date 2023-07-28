dependencyResolutionManagement {
  repositories {
    maven("https://maven.pkg.st/")
    maven("https://gradle.pkg.st/")
    maven("https://elide-snapshots.storage-download.googleapis.com/repository/v3/")
  }
  versionCatalogs {
    create("libs") {
      from(files("../gradle/elide.versions.toml"))
    }
  }
}

pluginManagement {
  repositories {
    maven("https://gradle.pkg.st/")
    maven("https://maven.pkg.st/")
    maven("https://elide-snapshots.storage-download.googleapis.com/repository/v3/")
  }
}

rootProject.name = "elideBuild"

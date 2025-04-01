pluginManagement {
  repositories {
    google {
      content {
        includeGroupByRegex("com\\.android.*")
        includeGroupByRegex("com\\.google.*")
        includeGroupByRegex("androidx.*")
      }
    }
    mavenCentral()
    gradlePluginPortal()
  }
}
dependencyResolutionManagement {
  repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
  repositories {
    google()
    mavenCentral()
  }
}

rootProject.name = "UtopiaApplication"
include(":app")
include(":modularization:core")
include(":modularization:component:analytics:api")
include(":modularization:component:atommanager:prod")
include(":modularization:component:clock:api")
include(":modularization:component:clock:prod")
include(":modularization:component:experiment:api")
include(":modularization:component:network:api")
include(":modularization:component:persistence:api")
include(":modularization:component:system:permissions:api")
include(":modularization:component:system:permissions:prod")
include(":modularization:component:thread:api")
include(":modularization:component:thread:prod")
include(":modularization:data:session")
include(":modularization:di:component")

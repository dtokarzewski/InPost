pluginManagement {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
    }
}
dependencyResolutionManagement {
    @Suppress("UnstableApiUsage")
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    @Suppress("UnstableApiUsage")
    repositories {
        google()
        mavenCentral()
    }
}
rootProject.name = "InPost Recruitment Task"

include(":app")
include(":core:common")
include(":core:designsystem")
include(":data:network")
include(":domain")
include(":domain:data")
include(":feature:shipmentlist")
include(":feature:shipmentlist:data")
include(":core:test")
include(":data:database")

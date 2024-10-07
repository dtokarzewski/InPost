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
include(":core:designsystem")
include(":feature:shipmentlist")
include(":data:network")
include(":domain:model")
include(":feature:shipmentlist:data")
include(":core:common")

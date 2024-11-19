pluginManagement {
    repositories {
        google()
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

rootProject.name = "FitIn"
include(":app")
include(":core:util")
include(":login_signup:login_signup_data")
include(":login_signup:login_signup_domain")
include(":login_signup:presentation")

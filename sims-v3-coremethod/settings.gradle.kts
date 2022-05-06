rootProject.name = "sims-api"

pluginManagement {
    val privateMavenUser: String by settings
    val privateMavenToken: String by settings
    val privateGradleUrl: String by settings

    repositories {
        gradlePluginPortal()
        maven {
            setUrl(privateGradleUrl)
            credentials {
                username = privateMavenUser
                password = privateMavenToken
            }
        }
    }
}

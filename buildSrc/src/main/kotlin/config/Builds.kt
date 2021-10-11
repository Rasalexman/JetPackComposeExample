package config

object Builds {
    const val MIN_VERSION = 21
    const val COMPILE_VERSION = 31
    const val TARGET_VERSION = 31
    const val BUILD_TOOLS = "30.0.2"
    const val APP_ID = "com.usell"

    val codeDirs = arrayListOf(
        "src/main/kotlin"
    )

    val resDirs = arrayListOf(
        "src/main/res",
        "src/main/res/fragments",
        "src/main/res/pages",
        "src/main/res/items",
        "src/main/res/icons"
    )

    object App {
        const val VERSION_CODE = 10001
        const val VERSION_NAME = "1.0.1"
    }

    object Types {
        const val DEBUG = "debug"
        const val RELEASE = "release"
    }
}
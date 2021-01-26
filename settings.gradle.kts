rootProject.name = "kore"

/* A list of modules included in this mono repo */
val services = arrayOf(
        "api"
)

val integrations = mapOf(
        "clients" to arrayOf(
                "youtube"
        )
)

/* A few utility functions for registering modules from arrays */
fun registerModules(parents: List<String>, children: Map<String, Array<String>>) {
    includeModule(parents)

    children.forEach { (newParent, newChildren) ->
        registerModules(parents + newParent, newChildren)
    }
}

fun registerModules(parents: List<String>, children: Array<String>) {
    includeModule(parents)

    children.forEach { child ->
        includeModule(parents + child)
    }
}

fun includeModule(path: List<String>) {
    include(path.joinToString(separator = ":"))
}

registerModules(listOf("services"), services)
registerModules(listOf("integrations"), integrations)

import react.dom.render
import kotlinx.browser.document
import kotlinx.browser.window

fun main() {
    document.title = "Hello Kotlin/JS"
    window.onload = {

        // entry point into the React world
        render(document.getElementById("root")) {
            child(Welcome::class) {
                attrs {
                    name = "Kotlin/JS"
                }
            }
        }
    }
}

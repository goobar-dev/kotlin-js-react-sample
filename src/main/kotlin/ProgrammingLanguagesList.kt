import kotlinx.browser.document
import kotlinx.browser.window
import kotlinx.html.js.onClickFunction
import react.RBuilder
import react.RComponent
import react.RProps
import react.RState
import react.dom.attrs
import react.dom.p

external interface LanguageListProps: RProps {
    var languages: List<String>
}

@JsExport
class ProgrammingLanguagesList: RComponent<LanguageListProps, RState>() {
    override fun RBuilder.render() {
        props.languages.forEach { language ->
            p {
                attrs {
                    onClickFunction = {
                        window.alert("Clicked $language")
                    }
                }
                key = language
                +language
            }
        }
    }
}
import kotlinx.html.InputType
import kotlinx.html.js.onChangeFunction
import kotlinx.html.js.onClickFunction
import org.w3c.dom.HTMLInputElement
import react.RBuilder
import react.RComponent
import react.RProps
import react.RState
import react.dom.attrs
import styled.*

external interface WelcomeProps : RProps {
    var name: String
}

data class WelcomeState(
    val title: String,
    val input: String = "",
    val languages: List<String> = emptyList()
) : RState

@ExperimentalJsExport
@JsExport
class Welcome(props: WelcomeProps) : RComponent<WelcomeProps, WelcomeState>(props) {

    init {
        state = WelcomeState(props.name, languages = listOf("Kotlin"))
    }

    override fun RBuilder.render() {
        styledDiv {
            css { +WelcomeStyles.textContainer }
            +state.title
        }
        styledInput {
            css { +WelcomeStyles.textInput }
            attrs {
                type = InputType.text
                onChangeFunction = { event ->
                    setState(
                        WelcomeState(
                            state.title,
                            (event.target as HTMLInputElement).value,
                            state.languages
                        )
                    )
                }
            }
        }
        styledButton {
            css { +WelcomeStyles.button }
            attrs {
                onClickFunction = {
                    console.log("Clicked the button")
                    setState(
                        WelcomeState(
                            state.title,
                            state.input,
                            state.languages + state.input
                        )
                    )
                }
            }
            +"Add Programming Language"
        }
        styledDiv {
            styledH1 {
                css { +WelcomeStyles.h1 }
                +"Programming Languages"
            }
            child(ProgrammingLanguagesList::class) {
                attrs.languages = state.languages
            }
        }
    }
}

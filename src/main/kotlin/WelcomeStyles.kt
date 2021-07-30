import kotlinx.css.*
import styled.StyleSheet

object WelcomeStyles : StyleSheet("WelcomeStyles", isStatic = true) {
    val textContainer by css {
        padding(8.px)

        backgroundColor = rgb(33, 148, 243)
        color = rgb(255, 255, 255)
        fontSize = 24.px
    }

    val textInput by css {
        margin(vertical = 8.px)

        fontSize = 16.px
    }

    val h1 by css {
        margin(vertical = 16.px)
        fontSize = 28.px
        fontWeight = FontWeight.bold
    }

    val button by css {
        margin(horizontal = 8.px)
        fontSize = 16.px
    }
} 

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberWindowState
import kotlinx.coroutines.delay

@Composable
@Preview
fun App() {
    val inputText = remember { mutableStateOf("") }
    val roomText = remember { mutableStateOf("room text") }
    val debugLengthText = remember { mutableStateOf("0") }

    val outputText = remember { mutableStateOf("") }
    val outputScrollState = rememberScrollState()

    val debugScrollState = rememberScrollState()
    val debugText = remember { mutableStateOf("") }

    val webSocketClient = remember { WebSocketClient(outputText, debugLengthText) }

    MaterialTheme {
        Row(modifier = Modifier.background(Color.Black)) {
            LeftColumn(this)
            MiddleColumn(this, webSocketClient, inputText, outputText, roomText, outputScrollState)
            RightColumn(this, debugText, debugScrollState)
        }

        ScrollToBottom(outputScrollState, debugScrollState)
        ManageWebSocketClient(webSocketClient)
    }
}

fun main() = application {
    val windowState = rememberWindowState(width = 1200.dp, height = 800.dp)

    Window(
        title = "Kotlin MUD Client",
        onCloseRequest = ::exitApplication,
        state = windowState
    ) {
        App()
    }
}

@Composable
fun ManageWebSocketClient(webSocketClient: WebSocketClient) {
    DisposableEffect(key1 = webSocketClient) {
        webSocketClient.start()
        onDispose {
            webSocketClient.stop()
        }
    }
}

@Composable
fun ScrollToBottom(outputScrollState: ScrollState, debugScrollState: ScrollState) {
    LaunchedEffect(key1 = Unit) {
        while (true) {
            delay(100)
            if (outputScrollState.canScrollForward) {
                outputScrollState.animateScrollTo(
                    outputScrollState.maxValue
                )
            }

            if (debugScrollState.canScrollForward) {
                debugScrollState.animateScrollTo(
                    debugScrollState.maxValue
                )
            }
        }
    }
}

fun sendAndClearInput(webSocketClient: WebSocketClient, inputText: MutableState<String>) {
    if (inputText.value.isNotEmpty()) {
        webSocketClient.sendMessage(inputText.value)
        inputText.value = ""
    }
}
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.RowScope
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier

@Composable
fun MiddleColumn(
    rowScope: RowScope,
    webSocketClient: WebSocketClient,
    inputText: MutableState<String>,
    outputText: MutableState<String>,
    roomText: MutableState<String>,
    scrollState: ScrollState
) =
    with(rowScope) {
        // Middle column with 3 rows
        Column(
            modifier = Modifier.weight(3.0f)
        ) {
            RoomText(this, roomText)
            OutputText(this, outputText, scrollState)
            InputRow(this, webSocketClient, inputText)
        }
    }
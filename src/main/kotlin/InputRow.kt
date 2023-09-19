import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.TextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.key.Key
import androidx.compose.ui.input.key.key
import androidx.compose.ui.input.key.onKeyEvent
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun InputRow(columnScope: ColumnScope, webSocketClient: WebSocketClient, inputText: MutableState<String>) =
    with(columnScope) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(0.7f)
                .border(1.dp, Color.White)
                .wrapContentHeight(align = Alignment.CenterVertically)
                .padding(8.dp)
        ) {
            Row(modifier = Modifier.wrapContentHeight(Alignment.CenterVertically)) {
                TextField(
                    value = inputText.value,
                    singleLine = true,
                    modifier = Modifier
                        .weight(1.0f)
                        .border(2.dp, Color.White)
                        .padding(4.dp)
                        .onKeyEvent {
                            when (it.key) {
                                Key.Enter -> {
                                    sendAndClearInput(webSocketClient, inputText)
                                    true
                                }

                                else -> true
                            }
                        },
                    textStyle = TextStyle(color = Color.White),
                    onValueChange = { inputText.value = it }
                )

                Spacer(modifier = Modifier.width(8.dp))

                Button(
                    onClick = { sendAndClearInput(webSocketClient, inputText) },
                    modifier = Modifier.weight(0.2f).align(Alignment.CenterVertically)
                ) {
                    Icon(
                        Icons.Filled.PlayArrow,
                        null
                    )
                }
            }
        }
    }

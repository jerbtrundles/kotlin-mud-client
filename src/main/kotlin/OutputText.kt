import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun OutputText(columnScope: ColumnScope, outputText: MutableState<String>, scrollState: ScrollState) =
    with(columnScope) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(3.0f)
                .border(1.dp, Color.White)
        ) {
            Text(
                text = outputText.value,
                modifier = Modifier
                    .padding(8.dp)
                    .fillMaxWidth()
                    .verticalScroll(scrollState),
                color = Color.White
            )
        }
    }
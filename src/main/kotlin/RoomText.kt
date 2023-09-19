import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun RoomText(columnScope: ColumnScope, roomText: MutableState<String>) =
    with(columnScope) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .border(1.dp, Color.White)
        ) {
            Text(
                text = roomText.value,
                modifier = Modifier
                    .padding(2.dp)
                    .fillMaxWidth(),
                color = Color.Red
            )
        }
    }
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

// Left column with border
@Composable
fun LeftColumn(rowScope: RowScope, itemsText: MutableState<String>, debugText: MutableState<String>) {
    with(rowScope) {
        Column(
            modifier = Modifier
                .fillMaxHeight()
                .weight(1.0f)
                .border(1.dp, Color.Cyan)
        ) {
            Box(
                modifier = Modifier
                    .weight(1f)
                    .border(1.dp, Color.White)
                    .fillMaxWidth()
            ) {
                Text(text = itemsText.value, color = Color.White, modifier = Modifier.padding(8.dp))
            }
            Box(
                modifier = Modifier
                    .weight(1f)
                    .border(1.dp, Color.Blue)
                    .fillMaxWidth()
            ) {
                // TODO: eventually make space for a players list
                Text(text = debugText.value, color = Color.White, modifier = Modifier.padding(8.dp))
            }
        }
    }
}
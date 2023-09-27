import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

// Right column with border
@Composable
fun RightColumn(rowScope: RowScope, npcText: MutableState<String>, monstersText: MutableState<String>) {
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
                Text(text = npcText.value, color = Color.White, modifier = Modifier.padding(8.dp))
            }
            Box(
                modifier = Modifier
                    .weight(1f)
                    .border(1.dp, Color.Blue)
                    .fillMaxWidth()
            ) {
                Text(text = monstersText.value, color = Color.White, modifier = Modifier.padding(8.dp))
            }
        }
    }
}

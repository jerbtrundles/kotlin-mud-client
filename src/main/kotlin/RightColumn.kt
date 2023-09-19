import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

// Right column with border
@Composable
fun RightColumn(rowScope: RowScope, debugText: MutableState<String>, debugScrollState: ScrollState) =
    with(rowScope) {
        Box(
            modifier = Modifier
                .weight(1f)
                .border(1.dp, Color.White)
                .fillMaxHeight()
        ) {
            Text(text = debugText.value)
        }
    }
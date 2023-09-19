import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

// Left column with border
@Composable
fun LeftColumn(rowScope: RowScope) =
    with(rowScope) {
        Box(
            modifier = Modifier
                .weight(1f)
                .border(1.dp, Color.White)
                .fillMaxHeight()
        ) {}
    }
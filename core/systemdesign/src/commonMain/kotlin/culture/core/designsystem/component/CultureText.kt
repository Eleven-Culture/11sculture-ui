package culture.core.designsystem.component

import androidx.compose.foundation.text.BasicText
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import culture.core.designsystem.theme.CultureTheme

@Composable
fun CultureText(
    text: String,
    modifier: Modifier = Modifier,
    style: TextStyle = CultureTheme.typography.body,
    color: Color = CultureTheme.colors.onSurface,
    maxLines: Int = Int.MAX_VALUE,
) = BasicText(text, modifier, style.copy(color = color), maxLines = maxLines)

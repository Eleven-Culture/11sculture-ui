package culture.core.designsystem.component

import androidx.compose.foundation.text.BasicText
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import culture.core.designsystem.theme.CultureTheme

@Composable
fun CultureText(
    text: String,
    modifier: Modifier = Modifier,
    style: TextStyle = CultureTheme.typography.body,
    color: Color = CultureTheme.colors.onSurface,
    maxLines: Int = Int.MAX_VALUE,
    textAlign: TextAlign? = null,
    fontWeight: FontWeight? = null,
    overflow: TextOverflow = TextOverflow.Clip,
) {
    val mergedStyle = style.merge(
        TextStyle(
            color = color,
            textAlign = textAlign ?: TextAlign.Unspecified,
            fontWeight = fontWeight
        )
    )
    BasicText(
        text,
        modifier,
        style = mergedStyle,
        maxLines = maxLines,
        overflow = overflow,
    )
}

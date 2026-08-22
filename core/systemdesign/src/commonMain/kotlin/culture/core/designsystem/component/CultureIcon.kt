package culture.core.designsystem.component

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.vector.ImageVector
import culture.core.designsystem.theme.CultureTheme

@Composable
fun CultureIcon(
    imageVector: ImageVector,
    contentDescription: String?,
    modifier: Modifier = Modifier,
    tint: Color = CultureTheme.colors.onSurface,
) = Image(imageVector, contentDescription, modifier, colorFilter = ColorFilter.tint(tint))

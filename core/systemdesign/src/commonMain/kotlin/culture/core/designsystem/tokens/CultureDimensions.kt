package culture.core.designsystem.tokens

import androidx.compose.foundation.shape.CornerBasedShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Immutable
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

object CultureSpacing {
    val none = 0.dp
    val xxs = 4.dp
    val xs = 8.dp
    val sm = 12.dp
    val md = 16.dp
    val lg = 24.dp
    val xl = 32.dp
    val xxl = 48.dp
}

val DefaultCultureSpacing = CultureSpacing

@Immutable
data class CultureShapes(
    val small: CornerBasedShape = RoundedCornerShape(8.dp),
    val medium: CornerBasedShape = RoundedCornerShape(14.dp),
    val large: CornerBasedShape = RoundedCornerShape(22.dp),
    val pill: CornerBasedShape = RoundedCornerShape(50),
)

val DefaultCultureShapes = CultureShapes()

@Immutable
data class CultureSizes(
    val minimumTouchTarget: Dp = 48.dp,
    val controlHeight: Dp = 52.dp,
    val iconSmall: Dp = 16.dp,
    val iconMedium: Dp = 24.dp,
    val iconLarge: Dp = 32.dp,
    val contentMaxWidth: Dp = 720.dp,
    val border: Dp = 1.dp,
)

val DefaultCultureSizes = CultureSizes()

@Immutable
data class CultureElevation(
    val none: Dp = 0.dp,
    val xs: Dp = 1.dp,
    val sm: Dp = 2.dp,
    val md: Dp = 4.dp,
    val lg: Dp = 8.dp,
    val xl: Dp = 16.dp,
    val xxl: Dp = 24.dp,
)

val DefaultElevation = CultureElevation()

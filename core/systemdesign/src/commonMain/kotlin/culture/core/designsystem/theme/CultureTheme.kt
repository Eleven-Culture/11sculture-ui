package culture.core.designsystem.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color
import culture.core.designsystem.tokens.*

private val LocalColors = staticCompositionLocalOf { CultureLightColors }
private val LocalTypography = staticCompositionLocalOf { DefaultCultureTypography }
private val LocalShapes = staticCompositionLocalOf { CultureShapes() }
private val LocalSizes = staticCompositionLocalOf { CultureSizes() }
private val LocalElevation = staticCompositionLocalOf { CultureElevation() }
private val LocalContentColor = compositionLocalOf { Color(CulturePalette.Graphite.value) }

object CultureTheme {
    val colors: CultureColorScheme @Composable @ReadOnlyComposable get() = LocalColors.current
    val typography: CultureTypography @Composable @ReadOnlyComposable get() = LocalTypography.current
    val shapes: CultureShapes @Composable @ReadOnlyComposable get() = LocalShapes.current
    val sizes: CultureSizes @Composable @ReadOnlyComposable get() = LocalSizes.current
    val elevations: CultureElevation @Composable @ReadOnlyComposable get() = LocalElevation.current
}

@Composable
fun CultureTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    colors: CultureColorScheme = if (darkTheme) CultureDarkColors else CultureLightColors,
    typography: CultureTypography = DefaultCultureTypography,
    shapes: CultureShapes = CultureShapes(),
    sizes: CultureSizes = CultureSizes(),
    elevation: CultureElevation = CultureElevation(),
    content: @Composable () -> Unit,
) {
    androidx.compose.runtime.CompositionLocalProvider(
        LocalColors provides colors,
        LocalTypography provides typography,
        LocalShapes provides shapes,
        LocalSizes provides sizes,
        LocalElevation provides elevation,
        content = content,
    )
}

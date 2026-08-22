package culture.core.designsystem.tokens

import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Color

/** Raw values. Components must use [CultureColorScheme] semantic roles instead. */
object CulturePalette {
    val White = Color(0xFFFFFFFF)
    val Ink = Color(0xFF171A18)
    val Graphite = Color(0xFF5D625E)
    val Mist = Color(0xFFF1F3EF)
    val Night = Color(0xFF111412)
    val NightSurface = Color(0xFF1A1E1B)
    val Slate = Color(0xFF35413D)
    val SlateSoft = Color(0xFFDDE5E1)
    val Success = Color(0xFF2F6B48)
    val Warning = Color(0xFF8A5A13)
    val Error = Color(0xFFB3261E)
}

@Immutable
data class CultureColorScheme(
    val primary: Color,
    val onPrimary: Color,
    val primaryContainer: Color,
    val onPrimaryContainer: Color,
    val background: Color,
    val onBackground: Color,
    val surface: Color,
    val onSurface: Color,
    val surfaceMuted: Color,
    val onSurfaceMuted: Color,
    val border: Color,
    val disabled: Color,
    val onDisabled: Color,
    val success: Color,
    val warning: Color,
    val error: Color,
)

val CultureLightColors = CultureColorScheme(
    CulturePalette.Slate, CulturePalette.White, CulturePalette.SlateSoft, Color(0xFF17231F),
    Color(0xFFF9FAF7), CulturePalette.Ink, CulturePalette.White, CulturePalette.Ink,
    CulturePalette.Mist, CulturePalette.Graphite, Color(0xFFC5CAC5), Color(0xFFE1E4E0),
    Color(0xFF858A86), CulturePalette.Success, CulturePalette.Warning, CulturePalette.Error,
)

val CultureDarkColors = CultureColorScheme(
    Color(0xFFB9C9C3), Color(0xFF24312D), Color(0xFF3B4944), Color(0xFFD8E8E2),
    CulturePalette.Night, Color(0xFFE2E6E2), CulturePalette.NightSurface, Color(0xFFE2E6E2),
    Color(0xFF252A26), Color(0xFFBCC3BD), Color(0xFF454C47), Color(0xFF303531),
    Color(0xFF858C86), Color(0xFF91D5AA), Color(0xFFFFB95F), Color(0xFFFFB4AB),
)

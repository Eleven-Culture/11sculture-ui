package culture.catalog

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import culture.core.designsystem.component.CultureButton
import culture.core.designsystem.component.CultureButtonStyle
import culture.core.designsystem.component.CultureCard
import culture.core.designsystem.component.CultureText
import culture.core.designsystem.component.CultureTextField
import culture.core.designsystem.theme.CultureTheme
import culture.core.designsystem.tokens.CultureSpacing

@Composable
fun Catalog() = CultureTheme {
    Column(
        modifier = Modifier.fillMaxSize()
            .background(CultureTheme.colors.background)
            .safeDrawingPadding()
            .verticalScroll(rememberScrollState())
            .padding(CultureSpacing.xl),
        verticalArrangement = Arrangement.spacedBy(CultureSpacing.lg),
    ) {
        CultureText("Culture UI", style = CultureTheme.typography.headline)
        CultureText(
            "A neutral, overridable Compose design system.",
            color = CultureTheme.colors.onSurfaceMuted,
        )

        CultureCard(Modifier.fillMaxWidth()) {
            CultureText("Actions", style = CultureTheme.typography.title)
            Spacer(Modifier.height(CultureSpacing.md))
            CultureButton("Continue", onClick = {})
            Spacer(Modifier.height(CultureSpacing.sm))
            CultureButton("Not now", onClick = {}, style = CultureButtonStyle.Secondary)
            Spacer(Modifier.height(CultureSpacing.sm))
            CultureButton("Unavailable", onClick = {}, enabled = false)
        }

        var value by remember { mutableStateOf("") }
        CultureCard(Modifier.fillMaxWidth()) {
            CultureText("Input", style = CultureTheme.typography.title)
            Spacer(Modifier.height(CultureSpacing.md))
            CultureTextField(value, { value = it }, "Display name", supportingText = "How others will see you")
        }

        CultureCard(Modifier.fillMaxWidth()) {
            CultureText("Semantic colors", style = CultureTheme.typography.title)
            Spacer(Modifier.height(CultureSpacing.md))
            Row(horizontalArrangement = Arrangement.spacedBy(CultureSpacing.sm)) {
                listOf(
                    CultureTheme.colors.primary,
                    CultureTheme.colors.success,
                    CultureTheme.colors.warning,
                    CultureTheme.colors.error,
                ).forEach { color ->
                    Box(Modifier.size(48.dp).background(color, CultureTheme.shapes.small))
                }
            }
        }

        CultureCard(Modifier.fillMaxWidth()) {
            CultureText("Elevation", style = CultureTheme.typography.title)
            CultureText(
                "Shadow levels used to communicate visual hierarchy.",
                color = CultureTheme.colors.onSurfaceMuted,
                style = CultureTheme.typography.bodySmall,
                modifier = Modifier.padding(top = CultureSpacing.xs),
            )
            Spacer(Modifier.height(CultureSpacing.lg))

            val elevation = CultureTheme.elevations
            val levels = listOf(
                "None" to elevation.none,
                "XS" to elevation.xs,
                "SM" to elevation.sm,
                "MD" to elevation.md,
                "LG" to elevation.lg,
                "XL" to elevation.xl,
                "XXL" to elevation.xxl,
            )
            levels.chunked(2).forEachIndexed { index, row ->
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(CultureSpacing.md),
                ) {
                    row.forEach { (label, value) ->
                        ElevationSample(label, value)
                    }
                }
                if (index < levels.lastIndex / 2) {
                    Spacer(Modifier.height(CultureSpacing.xl))
                }
            }
        }
    }
}

@Composable
private fun ElevationSample(label: String, elevation: Dp) {
    Column(
        modifier = Modifier.width(112.dp),
    ) {
        Box(
            modifier = Modifier
                .size(72.dp)
                .shadow(
                    elevation = elevation,
                    shape = CultureTheme.shapes.medium,
                    clip = false,
                )
                .background(
                    color = CultureTheme.colors.surface,
                    shape = CultureTheme.shapes.medium,
                ),
        )
        Spacer(Modifier.height(maxOf(CultureSpacing.sm, elevation)))
        CultureText(
            text = "$label · ${elevation.value.toInt()} dp",
            style = CultureTheme.typography.caption,
            color = CultureTheme.colors.onSurfaceMuted,
            maxLines = 1,
        )
    }
}

package culture.core.designsystem.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.semantics.Role
import culture.core.designsystem.theme.CultureTheme
import culture.core.designsystem.tokens.CultureSpacing

enum class CultureButtonStyle { Primary, Secondary, Ghost }

@Composable
fun CultureButton(
    label: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    style: CultureButtonStyle = CultureButtonStyle.Primary,
) {
    val colors = CultureTheme.colors
    val container = when {
        !enabled -> colors.disabled
        style == CultureButtonStyle.Primary -> colors.primary
        else -> Color.Transparent
    }
    val content = when {
        !enabled -> colors.onDisabled
        style == CultureButtonStyle.Primary -> colors.onPrimary
        else -> colors.primary
    }
    val border = if (enabled && style == CultureButtonStyle.Secondary) colors.primary else Color.Transparent
    val shape = CultureTheme.shapes.medium
    Box(
        modifier = modifier.fillMaxWidth()
            .defaultMinSize(minHeight = CultureTheme.sizes.controlHeight)
            .clip(shape).background(container)
            .border(CultureTheme.sizes.border, border, shape)
            .clickable(enabled = enabled, role = Role.Button, onClick = onClick)
            .padding(horizontal = CultureSpacing.lg, vertical = CultureSpacing.sm),
        contentAlignment = Alignment.Center,
    ) {
        CultureText(label, style = CultureTheme.typography.label, color = content, maxLines = 1)
    }
}

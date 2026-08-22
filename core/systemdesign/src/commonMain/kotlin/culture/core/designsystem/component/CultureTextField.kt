package culture.core.designsystem.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.text.input.VisualTransformation
import culture.core.designsystem.theme.CultureTheme
import culture.core.designsystem.tokens.CultureSpacing

@Composable
fun CultureTextField(
    value: String,
    onValueChange: (String) -> Unit,
    label: String,
    modifier: Modifier = Modifier,
    supportingText: String? = null,
    isError: Boolean = false,
    enabled: Boolean = true,
    visualTransformation: VisualTransformation = VisualTransformation.None,
) {
    val colors = CultureTheme.colors
    val borderColor = if (isError) colors.error else colors.border
    Column(modifier.fillMaxWidth()) {
        CultureText(label, style = CultureTheme.typography.caption,
            color = if (isError) colors.error else colors.onSurfaceMuted,
            modifier = Modifier.padding(bottom = CultureSpacing.xs))
        BasicTextField(
            value, onValueChange, enabled = enabled, singleLine = true,
            textStyle = CultureTheme.typography.body.copy(color = if (enabled) colors.onSurface else colors.onDisabled),
            cursorBrush = SolidColor(colors.primary), visualTransformation = visualTransformation,
            modifier = Modifier.fillMaxWidth(),
            decorationBox = { innerTextField ->
                Box(
                    Modifier.fillMaxWidth().defaultMinSize(minHeight = CultureTheme.sizes.controlHeight)
                        .clip(CultureTheme.shapes.medium)
                        .background(if (enabled) colors.surface else colors.disabled)
                        .border(CultureTheme.sizes.border, borderColor, CultureTheme.shapes.medium)
                        .padding(horizontal = CultureSpacing.md, vertical = CultureSpacing.sm),
                ) { innerTextField() }
            },
        )
        supportingText?.let {
            CultureText(it, style = CultureTheme.typography.caption,
                color = if (isError) colors.error else colors.onSurfaceMuted,
                modifier = Modifier.padding(top = CultureSpacing.xs))
        }
    }
}

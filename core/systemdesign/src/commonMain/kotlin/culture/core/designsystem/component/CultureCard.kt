package culture.core.designsystem.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import culture.core.designsystem.theme.CultureTheme
import culture.core.designsystem.tokens.CultureSpacing

@Composable
fun CultureCard(
    modifier: Modifier = Modifier,
    contentPadding: PaddingValues = PaddingValues(CultureSpacing.md),
    content: @Composable ColumnScope.() -> Unit,
) {
    val shape = CultureTheme.shapes.large
    Column(
        modifier.background(CultureTheme.colors.surface, shape)
            .border(CultureTheme.sizes.border, CultureTheme.colors.border, shape)
            .padding(contentPadding),
        content = content,
    )
}

package culture.catalog

import androidx.compose.ui.window.ComposeUIViewController
import platform.UIKit.UIViewController

fun CatalogViewController(): UIViewController = ComposeUIViewController {
    Catalog()
}

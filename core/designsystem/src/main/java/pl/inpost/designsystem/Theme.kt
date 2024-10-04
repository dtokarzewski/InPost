package pl.inpost.designsystem

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val inPostColorScheme = lightColorScheme(
    primary = Yellow,
    onPrimary = Color.White,
    surface = LightGray,
    surfaceContainer = Color.White,
    onSurface = DarkGray,
    onSurfaceVariant = MediumGray,
    error = Color.Red
)

@Composable
fun InPostTheme(
    content: @Composable () -> Unit,
) {
    MaterialTheme(
        colorScheme = inPostColorScheme,
        typography = typography,
        content = content,
    )
}

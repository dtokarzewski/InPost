package pl.inpost.designsystem

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val inPostColorScheme = lightColorScheme(
    primary = Yellow,
    onPrimary = Color.White,
    surface = LightGray,
    surfaceVariant = Color.White,
    surfaceContainer = Color.White,
    surfaceContainerLow = Color.White,
    onSurface = DarkGray,
    onSurfaceVariant = MediumGray,
    primaryContainer = Color.White,
    onPrimaryContainer = DarkGray,
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

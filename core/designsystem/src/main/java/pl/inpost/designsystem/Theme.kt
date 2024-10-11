package pl.inpost.designsystem

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val inPostColorScheme = lightColorScheme(
    primary = Yellow,
    onPrimary = Color.White,
    background = LighterGray,
    onBackground = Gray,
    surface = Color.White,
    surfaceVariant = Color.White,
    surfaceContainer = LightGray,
    surfaceContainerLow = Color.White,
    onSurface = DarkerGray,
    onSurfaceVariant = DarkGray,
    primaryContainer = Color.White,
    onPrimaryContainer = DarkerGray,
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

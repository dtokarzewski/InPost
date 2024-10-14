package pl.inpost.recruitmenttask.presentation.home

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import dagger.hilt.android.AndroidEntryPoint
import pl.inpost.designsystem.InPostTheme
import pl.inpost.shipmentlist.ui.ShipmentListScreen

@AndroidEntryPoint
class HomeActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            InPostTheme {
                ShipmentListScreen()
            }
        }
    }
}

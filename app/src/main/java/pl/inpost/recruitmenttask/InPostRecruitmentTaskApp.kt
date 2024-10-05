package pl.inpost.recruitmenttask

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import pl.inpost.common.AppInitializer
import javax.inject.Inject

@HiltAndroidApp
class InPostRecruitmentTaskApp : Application() {

    @Inject
    private lateinit var initializers: Set<@JvmSuppressWildcards AppInitializer>

    override fun onCreate() {
        super.onCreate()
        initializers.forEach { it.init(this) }
    }
}

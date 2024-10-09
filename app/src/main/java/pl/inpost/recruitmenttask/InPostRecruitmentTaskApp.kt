package pl.inpost.recruitmenttask

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import pl.inpost.common.AppInitializer
import javax.inject.Inject

@HiltAndroidApp
open class InPostRecruitmentTaskApp : Application() {

    @Inject
    lateinit var initializers: Set<@JvmSuppressWildcards AppInitializer>

    override fun onCreate() {
        super.onCreate()
        initializers.forEach { it.init(this) }
    }
}

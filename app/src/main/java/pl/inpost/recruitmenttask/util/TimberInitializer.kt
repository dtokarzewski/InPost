package pl.inpost.recruitmenttask.util

import android.app.Application
import pl.inpost.common.AppInitializer
import pl.inpost.recruitmenttask.BuildConfig
import timber.log.Timber
import javax.inject.Inject

class TimberInitializer @Inject constructor() : AppInitializer {

    override fun init(application: Application) {
        // TODO add production tree with crashlytics
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }
}
package pl.inpost.common

import android.app.Application

interface AppInitializer {
    fun init(application: Application)
}
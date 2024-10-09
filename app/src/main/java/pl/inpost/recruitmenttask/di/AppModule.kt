package pl.inpost.recruitmenttask.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dagger.multibindings.IntoSet
import pl.inpost.common.AppInitializer
import pl.inpost.recruitmenttask.util.TimberInitializer

@InstallIn(SingletonComponent::class)
@Module
abstract class AppModule {

    @Binds
    @IntoSet
    abstract fun bindAppInitializer(timberInitializer: TimberInitializer): AppInitializer

}
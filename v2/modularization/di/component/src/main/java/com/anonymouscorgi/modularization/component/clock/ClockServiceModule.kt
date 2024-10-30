package com.anonymouscorgi.modularization.component.clock

import com.anonymouscorgi.modularization.core.Atom
import dagger.Module
import dagger.Provides
import dagger.multibindings.ClassKey
import dagger.multibindings.IntoMap

@Module
object ClockServiceModule {

  @Provides
  @IntoMap
  @ClassKey(ClockService::class)
  fun provideClockService(): Atom = AndroidClockService()
}
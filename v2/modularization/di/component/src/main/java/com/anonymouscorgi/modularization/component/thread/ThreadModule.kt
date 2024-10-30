package com.anonymouscorgi.modularization.component.thread

import com.anonymouscorgi.modularization.component.atommanager.AtomManager
import com.anonymouscorgi.modularization.component.thread.api.UtopiaCoroutineDispatchers
import com.anonymouscorgi.modularization.component.thread.api.UtopiaExecutors
import com.anonymouscorgi.modularization.core.Atom
import dagger.Module
import dagger.Provides
import dagger.multibindings.ClassKey
import dagger.multibindings.IntoMap

@Module
object ThreadModule {

  @Provides
  @IntoMap
  @ClassKey(UtopiaExecutors::class)
  fun provideUtopiaExecutors(): Atom = ProdUtopiaExecutors()

  @Provides
  @IntoMap
  @ClassKey(UtopiaCoroutineDispatchers::class)
  fun provideUtopiaCoroutineDispatchers(atomManager: AtomManager): Atom =
    ProdUtopiaCoroutineDispatchers(atomManager)
}
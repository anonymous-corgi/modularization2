package com.anonymouscorgi.modularization.component.thread

import com.anonymouscorgi.modularization.core.Atom
import com.anonymouscorgi.modularization.core.AtomManager
import dagger.Module
import dagger.Provides
import dagger.multibindings.ClassKey
import dagger.multibindings.IntoMap

@Module
object ThreadModule {

  @Provides
  @IntoMap
  @ClassKey(ExecutorRegistry::class)
  fun provideUtopiaExecutors(): Atom = ProdExecutorRegistry()

  @Provides
  @IntoMap
  @ClassKey(CoroutineDispatcherRegistry::class)
  fun provideUtopiaCoroutineDispatchers(atomManager: AtomManager): Atom =
    ProdCoroutineDispatcherRegistry(atomManager)
}
package com.anonymouscorgi.modularization.component.thread

import com.anonymouscorgi.modularization.core.AtomManager
import com.anonymouscorgi.modularization.core.Atom
import dagger.Module
import dagger.Provides
import dagger.multibindings.ClassKey
import dagger.multibindings.IntoMap

@Module
object ThreadModule {

  @Provides
  @IntoMap
  @ClassKey(ExecutorManager::class)
  fun provideUtopiaExecutors(): Atom = ProdExecutorManager()

  @Provides
  @IntoMap
  @ClassKey(CoroutineDispatcherManager::class)
  fun provideUtopiaCoroutineDispatchers(atomManager: AtomManager): Atom =
    ProdCoroutineDispatcherManager(atomManager)
}
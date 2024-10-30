package com.anonymouscorgi.modularization.component.atommanager

import com.anonymouscorgi.modularization.component.clock.ClockServiceModule
import com.anonymouscorgi.modularization.component.thread.ThreadModule
import com.anonymouscorgi.modularization.core.Atom
import dagger.Module
import dagger.Provides
import javax.inject.Provider
import javax.inject.Singleton

@Module(includes = [ClockServiceModule::class, ThreadModule::class])
object AtomManagerModule {

  @Singleton
  @Provides
  fun provideAtomManager(atomProviders: Provider<Map<Class<*>, @JvmSuppressWildcards Provider<Atom>>>): AtomManager =
    ProdAtomManager(atomProviders)
}
package com.anonymouscorgi.modularization.component.atommanager.app

import com.anonymouscorgi.modularization.component.atommanager.ProdAppAtomManager
import com.anonymouscorgi.modularization.component.clock.ClockServiceModule
import com.anonymouscorgi.modularization.component.thread.ThreadModule
import com.anonymouscorgi.modularization.core.Atom
import com.anonymouscorgi.modularization.core.AtomManager
import dagger.Module
import dagger.Provides
import javax.inject.Provider
import javax.inject.Singleton

@Module(includes = [ClockServiceModule::class, ThreadModule::class])
object AppAtomManagerModule {

  @Singleton
  @Provides
  fun provideAtomManager(atomProviders: Provider<Map<Class<*>, @JvmSuppressWildcards Provider<Atom>>>): AtomManager =
    ProdAppAtomManager(atomProviders)
}
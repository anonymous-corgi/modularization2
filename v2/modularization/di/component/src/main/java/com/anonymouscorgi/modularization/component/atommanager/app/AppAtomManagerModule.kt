package com.anonymouscorgi.modularization.component.atommanager.app

import com.anonymouscorgi.modularization.component.atommanager.AtomManagerCore
import com.anonymouscorgi.modularization.component.atommanager.ProdAppAtomManager
import com.anonymouscorgi.modularization.component.clock.ClockServiceModule
import com.anonymouscorgi.modularization.component.system.permissions.PermissionsCheckerModule
import com.anonymouscorgi.modularization.component.thread.ThreadModule
import com.anonymouscorgi.modularization.core.Atom
import com.anonymouscorgi.modularization.core.AtomManager
import dagger.Module
import dagger.Provides
import javax.inject.Provider
import javax.inject.Singleton

@Module(includes = [ClockServiceModule::class, PermissionsCheckerModule::class, ThreadModule::class])
object AppAtomManagerModule {

  @Provides
  fun provideAppAtomManager(atomProviders: Provider<Map<Class<*>, @JvmSuppressWildcards Provider<Atom>>>): AtomManager =
    ProdAppAtomManager(AtomManagerCore(atomProviders))
}
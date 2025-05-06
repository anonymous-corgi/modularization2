package com.anonymouscorgi.modularization.component.atommanager.activity

import com.anonymouscorgi.modularization.component.atommanager.AtomManagerCore
import com.anonymouscorgi.modularization.component.atommanager.ProdActivityAtomManager
import com.anonymouscorgi.modularization.component.system.permissions.PermissionsRequesterModule
import com.anonymouscorgi.modularization.core.ActivityAtomManager
import com.anonymouscorgi.modularization.core.Atom
import com.anonymouscorgi.modularization.core.AtomManager
import dagger.Module
import dagger.Provides
import javax.inject.Provider
import javax.inject.Singleton

@Module(includes = [PermissionsRequesterModule::class])
object ActivityAtomManagerModule {

  @Provides
  fun provideActivityAtomManager(
    atomProviders: Provider<Map<Class<*>, @JvmSuppressWildcards Provider<Atom>>>,
    appAtomManager: AtomManager,
  ): ActivityAtomManager =
    ProdActivityAtomManager(AtomManagerCore(atomProviders), appAtomManager)
}
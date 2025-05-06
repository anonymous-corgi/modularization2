package com.anonymouscorgi.modularization.component.system.permissions

import com.anonymouscorgi.modularization.component.delegation.ActivityDelegator
import com.anonymouscorgi.modularization.core.Atom
import com.anonymouscorgi.modularization.core.AtomManager
import dagger.Module
import dagger.Provides
import dagger.multibindings.ClassKey
import dagger.multibindings.IntoMap

@Module
object PermissionsRequesterModule {

  @Provides
  @IntoMap
  @ClassKey(PermissionsRequester::class)
  fun providePermissionsRequester(
    activityDelegator: ActivityDelegator,
    appAtomManager: AtomManager,
  ): Atom = ProdPermissionsRequester(activityDelegator, appAtomManager)
}
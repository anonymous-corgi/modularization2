package com.anonymouscorgi.modularization.component.atommanager.activity

import com.anonymouscorgi.modularization.component.delegation.ActivityDelegator
import com.anonymouscorgi.modularization.core.ActivityAtomManager
import com.anonymouscorgi.modularization.core.AtomManager
import dagger.BindsInstance
import dagger.Component

@Component(modules = [ActivityAtomManagerModule::class])
interface ActivityAtomManagerComponent {

  fun getActivityAtomManager(): ActivityAtomManager

  @Component.Builder
  interface Builder {

    fun build(): ActivityAtomManagerComponent

    @BindsInstance
    fun appAtomManager(appAtomManager: AtomManager): Builder

    @BindsInstance
    fun activityDelegator(activityDelegator: ActivityDelegator): Builder
  }
}
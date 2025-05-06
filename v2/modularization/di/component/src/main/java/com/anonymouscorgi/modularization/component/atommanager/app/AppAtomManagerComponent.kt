package com.anonymouscorgi.modularization.component.atommanager.app

import android.content.Context
import com.anonymouscorgi.modularization.core.AtomManager
import dagger.BindsInstance
import dagger.Component

@Component(modules = [AppAtomManagerModule::class])
interface AppAtomManagerComponent {

  fun getAtomManager(): AtomManager

  @Component.Builder
  interface Builder {

    fun build(): AppAtomManagerComponent

    @BindsInstance
    fun appContext(appContext: Context): Builder
  }
}
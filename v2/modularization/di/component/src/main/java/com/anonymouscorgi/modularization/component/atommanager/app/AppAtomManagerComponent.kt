package com.anonymouscorgi.modularization.component.atommanager.app

import com.anonymouscorgi.modularization.component.AtomManagerReceiver
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppAtomManagerModule::class])
interface AppAtomManagerComponent {

  fun injectAtomManager(atomManagerReceiver: AtomManagerReceiver)
}
package com.anonymouscorgi.modularization.component.atommanager

import com.anonymouscorgi.modularization.component.AtomManagerReceiver
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AtomManagerModule::class])
interface AtomManagerComponent {

  fun injectAtomManager(atomManagerReceiver: AtomManagerReceiver)
}
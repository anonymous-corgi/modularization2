package com.anonymouscorgi.modularization.component

import com.anonymouscorgi.modularization.component.atommanager.AtomManager
import com.anonymouscorgi.modularization.component.atommanager.DaggerAtomManagerComponent
import javax.inject.Inject

class AtomManagerReceiver {

  @Inject lateinit var atomManager: AtomManager

  fun injectItself() {
    DaggerAtomManagerComponent.builder().build().injectAtomManager(this)
  }
}
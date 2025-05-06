package com.anonymouscorgi.modularization.component

import com.anonymouscorgi.modularization.component.atommanager.app.DaggerAppAtomManagerComponent
import com.anonymouscorgi.modularization.core.AtomManager
import javax.inject.Inject

class AtomManagerReceiver {

  @Inject lateinit var atomManager: AtomManager

  fun injectItself() {
    DaggerAppAtomManagerComponent.builder().build().injectAtomManager(this)
  }
}
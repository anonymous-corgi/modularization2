package com.anonymouscorgi.modularization.component.atommanager

import com.anonymouscorgi.modularization.core.ActivityAtomManager
import com.anonymouscorgi.modularization.core.Atom
import com.anonymouscorgi.modularization.core.AtomManager

class ProdActivityAtomManager(
  private val atomManagerCore: AtomManagerCore,
  private val appAtomManager: AtomManager,
) :
  ActivityAtomManager {

  override fun <A : Atom> get(clazz: Class<A>): A =
    if (atomManagerCore.isSupported(clazz)) {
      atomManagerCore.get(clazz)
    } else {
      appAtomManager.get(clazz)
    }
}
package com.anonymouscorgi.modularization.component.atommanager

import com.anonymouscorgi.modularization.core.Atom

interface AtomManager {
  fun <A : Atom> get(clazz: Class<A>): A
}
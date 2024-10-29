package com.anonymouscorgi.modularization.component.atommanager

import com.anonymouscorgi.modularization.component.clock.ClockService
import com.anonymouscorgi.modularization.core.Atom
import java.lang.IllegalArgumentException

class ProdAtomManager(private val clockService: Lazy<ClockService>) : AtomManager {

    @Suppress("UNCHECKED_CAST")
    override fun <A : Atom> get(clazz: Class<A>): A {
      return when (clazz) {
        ClockService::class.java -> clockService.value as A
        else -> throw IllegalArgumentException("Unsupported Atom Class type: ${clazz.name}")
      }
    }
}
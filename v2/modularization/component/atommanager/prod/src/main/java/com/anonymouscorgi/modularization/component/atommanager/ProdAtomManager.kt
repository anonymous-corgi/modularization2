package com.anonymouscorgi.modularization.component.atommanager

import com.anonymouscorgi.modularization.core.Atom
import com.anonymouscorgi.modularization.core.annotation.AtomRetention
import java.util.WeakHashMap
import javax.inject.Provider

class ProdAtomManager(atomProviders: Provider<Map<Class<*>, @JvmSuppressWildcards Provider<Atom>>>) :
  AtomManager {

  private val atomProviders: Map<Class<*>, Provider<Atom>> by lazy { atomProviders.get() }
  private val atomCacheStrong = mutableMapOf<Class<*>, Atom>()
  private val atomCacheWeak = WeakHashMap<Class<*>, Atom>()

  override fun <A : Atom> get(clazz: Class<A>): A {
    val atomRetention = clazz.getAnnotation(AtomRetention::class.java)
    val retention = atomRetention?.retention ?: AtomRetention.MULTITON

    return when (retention) {
      AtomRetention.SINGLETON -> getSingletonAtom(clazz, atomCacheStrong, atomProviders)
      AtomRetention.SINGLETON_WEAK -> getSingletonAtom(clazz, atomCacheWeak, atomProviders)
      else -> createAtom(clazz, atomProviders)
    }
  }

  companion object {

    @Suppress("UNCHECKED_CAST")
    private fun <A : Atom> getSingletonAtom(
      clazz: Class<A>,
      atomCache: MutableMap<Class<*>, Atom>,
      atomProviders: Map<Class<*>, Provider<Atom>>,
    ): A {
      var atom: Atom?
      atom = atomCache[clazz]
      if (atom == null) {
        atom = createAtom(clazz, atomProviders)
        synchronized(atomCache) { atom = atomCache.getOrPut(clazz) { atom as A } }
      }
      return atom as A
    }

    @Suppress("UNCHECKED_CAST")
    private fun <A : Atom> createAtom(
      clazz: Class<A>,
      atomProviders: Map<Class<*>, Provider<Atom>>,
    ): A {
      val provider = atomProviders[clazz]
        ?: throw IllegalArgumentException("Provider not found for class: $clazz")

      return provider.get().let { atom ->
        if (clazz.isInstance(atom)) {
          atom as A
        } else {
          throw ClassCastException("Provider for class: $clazz generated an instance of ${atom.javaClass}")
        }
      }
    }
  }
}
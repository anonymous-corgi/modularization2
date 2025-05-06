package com.anonymouscorgi.modularization.component.atommanager

import com.anonymouscorgi.modularization.core.Atom
import com.anonymouscorgi.modularization.core.AtomManager
import com.anonymouscorgi.modularization.core.annotation.AtomRetention
import java.util.WeakHashMap
import javax.inject.Provider

class AtomManagerCore(atomProviders: Provider<Map<Class<*>, @JvmSuppressWildcards Provider<Atom>>>) :
  AtomManager {

  private val atomCacheWeak = WeakHashMap<Class<*>, Atom>()
  private val atomCacheStrong = mutableMapOf<Class<*>, Atom>()
  private val atomProviders: Map<Class<*>, Provider<Atom>> by lazy { atomProviders.get() }

  override fun <A : Atom> get(clazz: Class<A>): A {
    val atomRetention = clazz.getAnnotation(AtomRetention::class.java)
    val retention = atomRetention?.retention ?: AtomRetention.MULTITON

    return when (retention) {
      AtomRetention.SINGLETON -> getSingletonAtom(clazz, atomCacheStrong, atomProviders)
      AtomRetention.SINGLETON_WEAK -> getSingletonAtom(clazz, atomCacheWeak, atomProviders)
      else -> createAtom(clazz, atomProviders)
    }
  }

  fun <A : Atom> isSupported(clazz: Class<A>): Boolean = atomProviders.containsKey(clazz)

  companion object {

    @Suppress("UNCHECKED_CAST")
    private fun <A : Atom> getSingletonAtom(
      clazz: Class<A>,
      atomCache: MutableMap<Class<*>, Atom>,
      atomProviders: Map<Class<*>, Provider<Atom>>,
    ): A {
      var atom: Atom? = atomCache[clazz]
      if (atom == null) {
        synchronized(atomCache) {
          atom = atomCache.getOrPut(clazz) { createAtom(clazz, atomProviders) }
        }
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
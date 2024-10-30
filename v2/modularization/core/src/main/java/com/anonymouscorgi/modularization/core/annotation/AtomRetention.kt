package com.anonymouscorgi.modularization.core.annotation

@Retention(AnnotationRetention.RUNTIME)
annotation class AtomRetention(val retention: Int = MULTITON) {

  companion object {

    const val SINGLETON: Int = 0

    const val SINGLETON_WEAK: Int = 1

    const val MULTITON: Int = 2
  }
}

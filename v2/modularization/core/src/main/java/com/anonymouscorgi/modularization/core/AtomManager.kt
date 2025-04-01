package com.anonymouscorgi.modularization.core

interface AtomManager {
  fun <A : Atom> get(clazz: Class<A>): A
}
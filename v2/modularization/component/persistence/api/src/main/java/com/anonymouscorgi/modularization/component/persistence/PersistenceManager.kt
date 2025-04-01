package com.anonymouscorgi.modularization.component.persistence

import com.anonymouscorgi.modularization.core.AtomManager
import com.anonymouscorgi.modularization.core.Manager

interface PersistenceManager : Manager {}

fun AtomManager.getPersistenceManager() : PersistenceManager = get(PersistenceManager::class.java)

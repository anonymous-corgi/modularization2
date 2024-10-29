package com.anonymouscorgi.modularization.component.atommanager

import com.anonymouscorgi.modularization.component.network.NetworkService
import com.anonymouscorgi.modularization.component.persistence.PersistenceManager

interface AtomInstanceManager {
  val networkService: NetworkService
  val persistenceManager: PersistenceManager
}
package com.anonymouscorgi.modularization.component.atommanager

import com.anonymouscorgi.modularization.component.clock.ClockService
import com.anonymouscorgi.modularization.component.network.NetworkService
import com.anonymouscorgi.modularization.component.persistence.PersistenceManager

interface AtomManager {
  val clockService: ClockService
  val networkService: NetworkService
  val persistenceManager: PersistenceManager
}
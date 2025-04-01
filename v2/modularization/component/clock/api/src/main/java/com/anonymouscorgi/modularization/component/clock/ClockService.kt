package com.anonymouscorgi.modularization.component.clock

import com.anonymouscorgi.modularization.core.AtomManager
import com.anonymouscorgi.modularization.core.Service
import com.anonymouscorgi.modularization.core.annotation.AtomRetention

@AtomRetention(retention = AtomRetention.SINGLETON)
interface ClockService : Service {

  fun currentTimeMillis(): Long

  fun uptimeMillis(): Long

  fun elapsedRealtime(): Long
}

fun AtomManager.getClockService() : ClockService = get(ClockService::class.java)

package com.anonymouscorgi.modularization.component.clock

import com.anonymouscorgi.modularization.core.Service

interface ClockService : Service {

  fun currentTimeMillis(): Long

  fun uptimeMillis(): Long

  fun elapsedRealtime(): Long
}
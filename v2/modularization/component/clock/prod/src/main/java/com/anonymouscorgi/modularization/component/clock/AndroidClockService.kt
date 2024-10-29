package com.anonymouscorgi.modularization.component.clock

import android.os.SystemClock

class AndroidClockService : ClockService {
  override fun currentTimeMillis(): Long {
    return System.currentTimeMillis()
  }

  override fun uptimeMillis(): Long {
    return SystemClock.uptimeMillis()
  }

  override fun elapsedRealtime(): Long {
    return SystemClock.elapsedRealtime()
  }
}
package com.anonymouscorgi.modularization.component.thread

import android.os.Handler
import android.os.Looper
import java.util.concurrent.Executor
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors
import java.util.concurrent.ScheduledExecutorService

class ProdExecutorManager() : ExecutorManager {

  override val Main: Executor = object : Executor {

    private val handler: Handler = Handler(Looper.getMainLooper())

    override fun execute(command: Runnable) {
      handler.post(command)
    }
  }

  override val Message: ScheduledExecutorService = Executors.newSingleThreadScheduledExecutor()

  override val HighSpeed: ExecutorService = Executors.newCachedThreadPool()

  override val LowPower: ExecutorService = Executors.newFixedThreadPool(2)
}

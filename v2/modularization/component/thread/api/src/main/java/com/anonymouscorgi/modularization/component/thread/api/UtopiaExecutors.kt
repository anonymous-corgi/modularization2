package com.anonymouscorgi.modularization.component.thread.api

import com.anonymouscorgi.modularization.core.Manager
import java.util.concurrent.Executor
import java.util.concurrent.ExecutorService
import java.util.concurrent.ScheduledExecutorService

/** The Executors interface provides a set of managed executors */
interface UtopiaExecutors : Manager {

  /**
   * Executor for running tasks on the main thread.
   * Primarily used for UI updates or operations requiring immediate user interaction.
   */
  val Main: Executor

  /**
   * Executor dedicated to message or communication-based tasks.
   * Configured as a high-priority, single-thread executor for streamlined message handling.
   */
  val Message: ScheduledExecutorService

  /**
   * High-speed executor for tasks requiring minimal latency and high throughput.
   * Uses a dynamic thread pool with high priority, ideal for performance-intensive tasks.
   */
  val HighSpeed: ExecutorService

  /**
   * Low-power executor for tasks optimized for energy efficiency.
   * Operates with low priority and a limited thread pool, suitable for background tasks.
   */
  val LowPower: ExecutorService
}
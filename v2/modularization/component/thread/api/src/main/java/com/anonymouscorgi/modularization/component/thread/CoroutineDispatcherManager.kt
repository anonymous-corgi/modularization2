package com.anonymouscorgi.modularization.component.thread

import com.anonymouscorgi.modularization.core.AtomManager
import com.anonymouscorgi.modularization.core.Manager
import com.anonymouscorgi.modularization.core.annotation.AtomRetention
import kotlinx.coroutines.CoroutineDispatcher

/** The CoroutineDispatchers interface provides a set of managed coroutine dispatchers. */
@AtomRetention(retention = AtomRetention.SINGLETON)
interface CoroutineDispatcherManager : Manager {

  /**
   * Dispatcher for running coroutines on the main thread.
   * Suitable for UI operations or tasks that require immediate user interaction.
   */
  val Main: CoroutineDispatcher

  /**
   * Dispatcher dedicated to message or communication-based tasks.
   * Configured as a high-priority, single-thread dispatcher for efficient message handling.
   */
  val Message: CoroutineDispatcher

  /**
   * High-speed dispatcher for coroutines that require minimal latency and high throughput.
   * Uses a dynamic thread pool with high priority, ideal for intensive operations.
   */
  val HighSpeed: CoroutineDispatcher

  /**
   * Low-power dispatcher for coroutines optimized for energy efficiency.
   * Operates with low priority and a limited thread pool, suitable for background tasks.
   */
  val LowPower: CoroutineDispatcher
}

fun AtomManager.getCoroutineDispatcherManager() : CoroutineDispatcherManager =
  get(CoroutineDispatcherManager::class.java)
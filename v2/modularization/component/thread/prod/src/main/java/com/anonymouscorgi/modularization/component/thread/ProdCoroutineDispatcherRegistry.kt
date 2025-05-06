package com.anonymouscorgi.modularization.component.thread

import com.anonymouscorgi.modularization.core.AtomManager
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.asCoroutineDispatcher

class ProdCoroutineDispatcherRegistry(atomManager: AtomManager) : CoroutineDispatcherRegistry {

  private val executorRegistry: ExecutorRegistry by lazy { atomManager.executorRegistry() }

  override val Main: CoroutineDispatcher = Dispatchers.Main

  override val Message: CoroutineDispatcher by lazy { executorRegistry.Message.asCoroutineDispatcher() }

  override val HighSpeed: CoroutineDispatcher by lazy { executorRegistry.HighSpeed.asCoroutineDispatcher() }

  override val LowPower: CoroutineDispatcher by lazy { executorRegistry.LowPower.asCoroutineDispatcher() }
}
package com.anonymouscorgi.modularization.component.thread

import com.anonymouscorgi.modularization.core.AtomManager
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.asCoroutineDispatcher

class ProdCoroutineDispatcherManager(atomManager: AtomManager) : CoroutineDispatcherManager {

  private val executorManager: ExecutorManager by lazy { atomManager.getExecutorManager()}

  override val Main: CoroutineDispatcher = Dispatchers.Main

  override val Message: CoroutineDispatcher by lazy { executorManager.Message.asCoroutineDispatcher() }

  override val HighSpeed: CoroutineDispatcher by lazy { executorManager.HighSpeed.asCoroutineDispatcher() }

  override val LowPower: CoroutineDispatcher by lazy { executorManager.LowPower.asCoroutineDispatcher() }
}
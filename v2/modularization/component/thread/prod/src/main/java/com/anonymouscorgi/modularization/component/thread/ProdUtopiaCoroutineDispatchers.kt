package com.anonymouscorgi.modularization.component.thread

import com.anonymouscorgi.modularization.component.thread.api.UtopiaCoroutineDispatchers
import com.anonymouscorgi.modularization.component.thread.api.UtopiaExecutors
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.asCoroutineDispatcher

class ProdUtopiaCoroutineDispatchers(private val utopiaExecutors: UtopiaExecutors) :
  UtopiaCoroutineDispatchers {

  override val Main: CoroutineDispatcher = Dispatchers.Main

  override val Message: CoroutineDispatcher by lazy { utopiaExecutors.Message.asCoroutineDispatcher() }

  override val HighSpeed: CoroutineDispatcher by lazy { utopiaExecutors.HighSpeed.asCoroutineDispatcher() }

  override val LowPower: CoroutineDispatcher by lazy { utopiaExecutors.LowPower.asCoroutineDispatcher() }
}
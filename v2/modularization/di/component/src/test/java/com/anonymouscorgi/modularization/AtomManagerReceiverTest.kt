package com.anonymouscorgi.modularization

import com.anonymouscorgi.modularization.component.AtomManagerReceiver
import com.anonymouscorgi.modularization.component.clock.ClockService
import com.anonymouscorgi.modularization.component.thread.api.UtopiaCoroutineDispatchers
import com.google.common.truth.Truth.assertThat
import org.junit.Test

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class AtomManagerReceiverTest {

  @Test
  fun injectItself_injectsAtomManager() {
    val receiver = AtomManagerReceiver()
    receiver.injectItself()

    assertThat(receiver.atomManager).isNotNull()

    val clockService1 = receiver.atomManager.get(ClockService::class.java)
    val clockService2 = receiver.atomManager.get(ClockService::class.java)

    assertThat(clockService1).isNotNull()
    assertThat(clockService2).isEqualTo(clockService1)
  }

  @Test
  fun injectItself_getUtopiaCoroutineDispatchers_injectsAtomManager() {
    val receiver = AtomManagerReceiver()
    receiver.injectItself()

    assertThat(receiver.atomManager).isNotNull()

    val utopiaCoroutineDispatchers1 =
      receiver.atomManager.get(UtopiaCoroutineDispatchers::class.java)
    val utopiaCoroutineDispatchers2 =
      receiver.atomManager.get(UtopiaCoroutineDispatchers::class.java)

    assertThat(utopiaCoroutineDispatchers1).isNotNull()
    assertThat(utopiaCoroutineDispatchers2).isEqualTo(utopiaCoroutineDispatchers1)
  }
}
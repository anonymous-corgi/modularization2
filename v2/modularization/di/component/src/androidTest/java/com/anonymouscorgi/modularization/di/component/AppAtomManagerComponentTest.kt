package com.anonymouscorgi.modularization.di.component

import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.anonymouscorgi.modularization.component.atommanager.app.DaggerAppAtomManagerComponent
import com.anonymouscorgi.modularization.component.clock.getClockService
import com.anonymouscorgi.modularization.component.thread.getCoroutineDispatcherManager
import com.google.common.truth.Truth.assertThat
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class AppAtomManagerComponentTest {

  @Test
  fun injectItself_injectsAtomManager() {
    val appAtomManager =
      DaggerAppAtomManagerComponent.builder()
        .appContext(ApplicationProvider.getApplicationContext()).build().getAtomManager()

    assertThat(appAtomManager).isNotNull()

    val clockService1 = appAtomManager.getClockService()
    val clockService2 = appAtomManager.getClockService()

    assertThat(clockService1).isNotNull()
    assertThat(clockService2).isEqualTo(clockService1)
  }

  @Test
  fun injectItself_getUtopiaCoroutineDispatchers_injectsAtomManager() {
    val appAtomManager =
      DaggerAppAtomManagerComponent.builder()
        .appContext(ApplicationProvider.getApplicationContext()).build().getAtomManager()

    assertThat(appAtomManager).isNotNull()

    val utopiaCoroutineDispatchers1 =
      appAtomManager.getCoroutineDispatcherManager()
    val utopiaCoroutineDispatchers2 =
      appAtomManager.getCoroutineDispatcherManager()

    assertThat(utopiaCoroutineDispatchers1).isNotNull()
    assertThat(utopiaCoroutineDispatchers2).isEqualTo(utopiaCoroutineDispatchers1)
  }
}
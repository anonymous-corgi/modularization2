package com.anonymouscorgi.modularization.di.component

import androidx.test.core.app.ApplicationProvider
import com.anonymouscorgi.modularization.component.atommanager.app.DaggerAppAtomManagerComponent
import com.anonymouscorgi.modularization.component.clock.getClockService
import com.anonymouscorgi.modularization.component.thread.getCoroutineDispatcherManager
import com.google.common.truth.Truth.assertThat
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner

@RunWith(RobolectricTestRunner::class)
class AppAtomManagerComponentTest {

  @Test
  fun getAtomManager_returnsAtomManager() {
    val appAtomManager =
      DaggerAppAtomManagerComponent.builder()
        .appContext(ApplicationProvider.getApplicationContext())
        .build()
        .getAtomManager()

    assertThat(appAtomManager).isNotNull()
  }

  @Test
  fun getClockService_returnsSameClockService() {
    val appAtomManager =
      DaggerAppAtomManagerComponent.builder()
        .appContext(ApplicationProvider.getApplicationContext()).build().getAtomManager()

    val clockService1 = appAtomManager.getClockService()
    val clockService2 = appAtomManager.getClockService()

    assertThat(clockService1).isNotNull()
    assertThat(clockService2).isEqualTo(clockService1)
  }

  @Test
  fun getCoroutineDispatcherManager_returnsSameCoroutineDispatcherManager() {
    val appAtomManager =
      DaggerAppAtomManagerComponent.builder()
        .appContext(ApplicationProvider.getApplicationContext()).build().getAtomManager()

    val utopiaCoroutineDispatchers1 =
      appAtomManager.getCoroutineDispatcherManager()
    val utopiaCoroutineDispatchers2 =
      appAtomManager.getCoroutineDispatcherManager()

    assertThat(utopiaCoroutineDispatchers1).isNotNull()
    assertThat(utopiaCoroutineDispatchers2).isEqualTo(utopiaCoroutineDispatchers1)
  }
}
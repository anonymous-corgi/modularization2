package com.anonymouscorgi.modularization.di.component

import androidx.test.core.app.ApplicationProvider
import com.anonymouscorgi.modularization.component.atommanager.activity.DaggerActivityAtomManagerComponent
import com.anonymouscorgi.modularization.component.atommanager.app.DaggerAppAtomManagerComponent
import com.anonymouscorgi.modularization.component.clock.getClockService
import com.anonymouscorgi.modularization.component.delegation.ActivityDelegator
import com.anonymouscorgi.modularization.component.system.permissions.getPermissionsRequester
import com.anonymouscorgi.modularization.component.thread.getCoroutineDispatcherManager
import com.google.common.truth.Truth.assertThat
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito.mock
import org.robolectric.RobolectricTestRunner

@RunWith(RobolectricTestRunner::class)
class ActivityAtomManagerComponentTest {

  @Test
  fun getActivityAtomManager_returnsActivityAtomManager() {
    val activityDelegator = mock(ActivityDelegator::class.java)
    val appAtomManager =
      DaggerAppAtomManagerComponent.builder()
        .appContext(ApplicationProvider.getApplicationContext()).build().getAtomManager()

    val activityAtomManager =
      DaggerActivityAtomManagerComponent.builder()
        .appAtomManager(appAtomManager)
        .activityDelegator(activityDelegator)
        .build()
        .getActivityAtomManager()

    assertThat(activityAtomManager).isNotNull()
  }

  @Test
  fun getPermissionsRequester_returnsPermissionsRequester() {
    val activityDelegator = mock(ActivityDelegator::class.java)
    val appAtomManager =
      DaggerAppAtomManagerComponent.builder()
        .appContext(ApplicationProvider.getApplicationContext()).build().getAtomManager()
    val activityAtomManager =
      DaggerActivityAtomManagerComponent.builder()
        .appAtomManager(appAtomManager)
        .activityDelegator(activityDelegator)
        .build()
        .getActivityAtomManager()

    val permissionsRequester = activityAtomManager.getPermissionsRequester()

    assertThat(permissionsRequester).isNotNull()
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
package com.anonymouscorgi.modularization.component.system.permissions

import com.anonymouscorgi.modularization.component.delegation.ActivityDelegator
import com.anonymouscorgi.modularization.core.AtomManager
import java.util.concurrent.atomic.AtomicInteger

class ProdPermissionsRequester(
  private val activityDelegator: ActivityDelegator,
  private val atomManager: AtomManager,
) : PermissionsRequester {

  private val requestCodeGenerator = AtomicInteger(1024)
  private val pendingRequests = mutableMapOf<Int, PermissionsRequester.Callback>()

  override fun requestPermissions(
    permissions: Array<String>,
    callback: PermissionsRequester.Callback,
  ) {
    val requestCode = requestCodeGenerator.getAndIncrement()
    synchronized(pendingRequests) {
      pendingRequests[requestCode] = callback
    }
    activityDelegator.requestPermissions(permissions, requestCode)
  }

  override fun notifyRequestPermissionsResult(
    requestCode: Int,
    permissions: Array<String>,
    grantResults: IntArray,
  ) {
    val callback: PermissionsRequester.Callback? =
      synchronized(pendingRequests) { pendingRequests.remove(requestCode) }
    if (callback == null) {
      throw IllegalStateException("Unable to find PermissionsRequester.Callback with requestCode: $requestCode")
    }
    callback.onRequestPermissionsResult(permissions, grantResults)
  }

  override fun checkSelfPermission(permission: String): Boolean =
    atomManager.getPermissionsChecker().checkSelfPermission(permission)
}
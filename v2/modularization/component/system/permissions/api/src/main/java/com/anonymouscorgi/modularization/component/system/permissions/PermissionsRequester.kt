package com.anonymouscorgi.modularization.component.system.permissions

import com.anonymouscorgi.modularization.core.ActivityAtomManager
import com.anonymouscorgi.modularization.core.AtomManager

/**
 * An interface for components that can check, request, and process runtime permission results.
 */
interface PermissionsRequester : PermissionsChecker {

  /**
   * Requests a set of permissions from the user.
   */
  fun requestPermissions(permissions: Array<String>, callback: Callback)

  /**
   * Notifies the requester of a permission request result from the Android framework.
   */
  fun notifyRequestPermissionsResult(
    requestCode: Int,
    permissions: Array<String>,
    grantResults: IntArray,
  )

  interface Callback {
    fun onRequestPermissionsResult(permissions: Array<String>, grantResults: IntArray)
  }
}

fun ActivityAtomManager.getPermissionsRequester(): PermissionsRequester =
  get(PermissionsRequester::class.java)
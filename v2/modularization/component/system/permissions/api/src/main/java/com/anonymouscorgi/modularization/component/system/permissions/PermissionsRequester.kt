package com.anonymouscorgi.modularization.component.system.permissions

interface PermissionsRequester {
  fun requestPermissions(permissions: Array<String>, callback: Callback)

  interface Callback {
    fun onRequestPermissionsResult(permissions: Array<String>, grantResults: IntArray)
  }
}
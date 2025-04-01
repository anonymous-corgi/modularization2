package com.anonymouscorgi.modularization.component.system.permissions

import android.content.Context
import android.content.pm.PackageManager
import androidx.core.content.ContextCompat

class ProdPermissionsManager(
  private val appContext: Context,
  private val permissionsRequester: PermissionsRequester,
) : PermissionsManager {

  override fun checkSelfPermission(permission: String): Boolean =
    ContextCompat.checkSelfPermission(appContext, permission) == PackageManager.PERMISSION_GRANTED

  override fun requestPermissions(
    permissions: Array<String>,
    callback: PermissionsRequester.Callback,
  ) {
    permissionsRequester.requestPermissions(permissions, callback)
  }
}
package com.anonymouscorgi.modularization.component.system.permissions

import android.content.Context
import android.content.pm.PackageManager
import androidx.core.content.ContextCompat

class ProdPermissionsChecker(private val appContext: Context) : PermissionsChecker {

  override fun checkSelfPermission(permission: String): Boolean =
    ContextCompat.checkSelfPermission(appContext, permission) == PackageManager.PERMISSION_GRANTED
}
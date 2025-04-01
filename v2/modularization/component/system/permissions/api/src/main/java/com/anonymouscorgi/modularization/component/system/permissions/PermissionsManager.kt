package com.anonymouscorgi.modularization.component.system.permissions

import com.anonymouscorgi.modularization.core.AtomManager
import com.anonymouscorgi.modularization.core.Manager

interface PermissionsManager : PermissionsRequester, Manager {
  fun checkSelfPermission(permission: String): Boolean
}

fun AtomManager.getPermissionsManager(): PermissionsManager = get(PermissionsManager::class.java)
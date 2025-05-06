package com.anonymouscorgi.modularization.component.system.permissions

import com.anonymouscorgi.modularization.core.Atom
import com.anonymouscorgi.modularization.core.AtomManager

/** An [Atom] responsible for checking runtime permissions. */
interface PermissionsChecker : Atom {

  /**
   * Checks whether the application has been granted a specific permission.
   */
  fun checkSelfPermission(permission: String): Boolean
}

fun AtomManager.getPermissionsChecker(): PermissionsChecker = get(PermissionsChecker::class.java)
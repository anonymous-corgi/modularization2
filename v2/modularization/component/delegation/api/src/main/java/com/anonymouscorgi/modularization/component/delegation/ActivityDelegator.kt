package com.anonymouscorgi.modularization.component.delegation

/**
 * Interface for delegating Android Activity-specific operations.
 *
 * This interface provides a contract for classes that need to interact with
 * Android Activity functionalities, such as requesting runtime permissions,
 * without having a direct dependency on an `Activity` instance. This is
 * particularly useful in contexts like Presenters, ViewModels, or utility classes
 * that operate outside the immediate lifecycle of an Activity but still require
 * its capabilities.
 */
interface ActivityDelegator {

  /**
   * Requests permissions to be granted to this application.
   *
   * This method is a delegate for the `ActivityCompat.requestPermissions()`
   * or the equivalent `Activity.requestPermissions()` method.
   */
  fun requestPermissions(permissions: Array<String>, requestCode: Int)
}
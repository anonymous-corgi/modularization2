package com.anonymouscorgi.modularization.component.system.permissions

import android.content.Context
import com.anonymouscorgi.modularization.core.Atom
import dagger.Module
import dagger.Provides
import dagger.multibindings.ClassKey
import dagger.multibindings.IntoMap

@Module
object PermissionsCheckerModule {

  @Provides
  @IntoMap
  @ClassKey(PermissionsChecker::class)
  fun providePermissionsChecker(appContext: Context): Atom = ProdPermissionsChecker(appContext)
}
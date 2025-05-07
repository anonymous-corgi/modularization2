package com.anonymouscorgi.modularization.data.framework

import android.os.Parcelable
import java.util.UUID
import kotlinx.parcelize.Parcelize

@Parcelize
data class SessionConfig(
  val sessionId: Long = UUID.randomUUID().leastSignificantBits,
  val environment: Environment = Environment.PRODUCTION,
) : Parcelable
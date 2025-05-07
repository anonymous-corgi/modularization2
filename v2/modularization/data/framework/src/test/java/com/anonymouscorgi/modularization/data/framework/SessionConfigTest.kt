package com.anonymouscorgi.modularization.data.framework

import com.google.common.truth.Truth
import org.junit.Test

class SessionConfigTest {

  @Test
  fun newInstance_createsNewSessionConfig() {
    val sessionConfig = SessionConfig()

    Truth.assertThat(sessionConfig.sessionId).isNotNull()
    Truth.assertThat(sessionConfig.environment).isEqualTo(Environment.PRODUCTION)
  }
}
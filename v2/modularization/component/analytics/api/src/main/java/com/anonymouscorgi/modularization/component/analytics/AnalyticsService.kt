package com.anonymouscorgi.modularization.component.analytics

import com.anonymouscorgi.modularization.core.AtomManager
import com.anonymouscorgi.modularization.core.Service

interface AnalyticsService : Service {}

fun AtomManager.getAnalyticsService() : AnalyticsService = get(AnalyticsService::class.java)

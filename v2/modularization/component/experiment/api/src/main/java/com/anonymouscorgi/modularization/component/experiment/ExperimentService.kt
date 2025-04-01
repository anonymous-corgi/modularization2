package com.anonymouscorgi.modularization.component.experiment

import com.anonymouscorgi.modularization.core.AtomManager
import com.anonymouscorgi.modularization.core.Service

interface ExperimentService : Service {}

fun AtomManager.getExperimentService() : ExperimentService = get(ExperimentService::class.java)

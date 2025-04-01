package com.anonymouscorgi.modularization.component.network

import com.anonymouscorgi.modularization.core.AtomManager
import com.anonymouscorgi.modularization.core.Service

interface NetworkService: Service {}

fun AtomManager.getNetworkService() : NetworkService = get(NetworkService::class.java)

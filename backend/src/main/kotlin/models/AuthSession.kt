package dev.airdead.backend.models

import kotlinx.serialization.Serializable

@Serializable
data class AuthSession(val token: String?)
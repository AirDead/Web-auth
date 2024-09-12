package dev.airdead.backend.auth

abstract class OAuthProvider {
    abstract fun getAuthUrl(): String
}
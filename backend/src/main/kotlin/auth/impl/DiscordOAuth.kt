package dev.airdead.backend.auth.impl

import dev.airdead.backend.auth.OAuthProvider

class DiscordOAuth : OAuthProvider() {
    override fun getAuthUrl(): String {
        return "https://discord.com/oauth2/authorize?client_id=1283830472283131936&response_type=code&redirect_uri=https%3A%2F%2Flocalhost%3A8080%2Fcallback&scope=identify+email"
    }
}
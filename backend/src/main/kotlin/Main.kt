package dev.airdead.backend

import dev.airdead.backend.auth.impl.DiscordOAuth
import dev.airdead.backend.models.UserSession
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.http.content.*
import io.ktor.server.netty.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import io.ktor.server.sessions.*

val authSystem = DiscordOAuth()

fun main() {
    embeddedServer(
        Netty,
        port = 8080,
        host = "0.0.0.0",
        module = Application::configureRouting
    ).start(wait = true)
}

fun Application.configureRouting() {
    install(Sessions) {
        cookie<UserSession>("USER_SESSION") {
            cookie.path = "/"
        }
    }

    routing {
        staticResources("static", "static")

        get("/") {
            val name = call.request.queryParameters["name"]

            if (name != null) {
                call.sessions.set(UserSession(name))

                call.respondRedirect(authSystem.getAuthUrl())
            } else {
                call.respondText("Name parameter missing", status = HttpStatusCode.BadRequest)
            }
        }

        get("/callback") {
            val session = call.sessions.get<UserSession>()

            if (session != null) {
                val name = session.name

                call.sessions.clear<UserSession>()

                call.respondText("Authorization successful for user: $name")
            } else {
                call.respondText("No session found", status = HttpStatusCode.BadRequest)
            }
        }
    }
}

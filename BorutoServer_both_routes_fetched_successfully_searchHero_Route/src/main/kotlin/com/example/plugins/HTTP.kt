package com.example.plugins

import io.ktor.server.plugins.defaultheaders.*
import io.ktor.server.application.*
import java.time.Duration

fun Application.configureHTTP() {
    install(DefaultHeaders) {
      val oneYearInSeconds = Duration.ofDays(365).seconds


        header(name=io.ktor.http.HttpHeaders.CacheControl,
            "public, max-age=${oneYearInSeconds}, immutable")
    }

}

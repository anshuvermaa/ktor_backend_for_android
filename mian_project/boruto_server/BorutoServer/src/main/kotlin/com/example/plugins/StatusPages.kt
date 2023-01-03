package com.example.plugins

import io.ktor.server.routing.*
import io.ktor.http.*
import io.ktor.server.plugins.statuspages.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import javax.naming.AuthenticationException

fun Application.configureStatusPages(){
   // when ever you going to access the the end point which doesnt exist
   // we only recieve status code like 404 and nothing
   // so this plugin used to set custom messages
   install(StatusPages){
           status(HttpStatusCode.NotFound){call,status ->
               call.respond(
              message = "Page Not Found",
              status = HttpStatusCode.NotFound
               )
              }
      exception<AuthenticationException>{call,status ->
         call.respond(
            message = "We caught an exception",
            status=HttpStatusCode.OK
         )

      }
   }
}
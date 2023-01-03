package com.example

import io.ktor.server.application.*
import io.ktor.http.*
import io.ktor.server.netty.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun main(args: Array<String>): Unit =
    EngineMain.main(args)

@Suppress("unused") // application.conf references the main function. This annotation prevents the IDE from marking it as unused.
fun Application.module() {

    routing {
        get("/") {
            call.respondText("Hello World!")
        }
        get("/users/{username}") {
            val username = call.parameters["username"]
            val header =call.request.headers["Connection"]
            if(username=="admin"){
                call.response.header(name="CustomeHeader","admin")
                call.respond(message = "Hello admin", status = HttpStatusCode.OK)
            }
            call.respondText ("greeting, $username with header:  ${header}" )
        }
        get("/user") {
            val name=call.request.queryParameters["name"]
            val age=call.request.queryParameters["age"]
            call.respondText("hi ,my name is $name and my age is $age")
          }
        get("/person"){4
            try {
            val person =person(name = "sachinVerma", age=26)
            call.respond(message=person, status = HttpStatusCode.OK)

            } catch (e:Exception){
                call.respond(message = "${e.message}", status = HttpStatusCode.BadRequest)
            }
        }
    }
}

@kotlinx.serialization.Serializable
class person(val name: String, val age: Int)

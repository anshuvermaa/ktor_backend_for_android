package com.example

import io.ktor.application.*
import io.ktor.features.*
import io.ktor.http.*
import io.ktor.http.content.*
import io.ktor.response.*
import io.ktor.routing.*
import io.ktor.serialization.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*

fun main(){
    embeddedServer(Netty, port = 8080, watchPaths = listOf("classes,resources")){
        install(ContentNegotiation){
            json()
        }
        module()
    }.start(wait = true)
}

fun Application.module(){
    install(CallLogging)
    install(Routing) {
        static {  }

//        simple routing
        get("/") {
            call.respondText("Hello World!")
        }


        //geting paarms routes and creating new header on given condition
        get("/users/{username}") {
            val username = call.parameters["username"]
            val header =call.request.headers["Connection"]
            if(username=="admin"){
                call.response.header(name="CustomeHeader","admin")
                call.respond(message = "Hello admin", status = HttpStatusCode.OK)
            }
            call.respondText ("greeting, $username with header:  $header" )
        }


        // pashing and accessing queries
        get("/user") {
            val name=call.request.queryParameters["name"]
            val age=call.request.queryParameters["age"]
            call.respondText("hi ,my name is $name and my age is $age")
        }

        // passing object to response with the help of serialization
        get("/person"){4
            try {
                val person =person(name = "sachinVerma", age=26)
                call.respond(message=person, status = HttpStatusCode.OK)

            } catch (e:Exception){
                call.respond(message = "${e.message}", status = HttpStatusCode.BadRequest)
            }

        }


        // redirecting requests
        get("/redirect"){
            call.respondRedirect(url="/moved",permanent = false)
        }
        get("/moved"){
            call.respondText("You have been successfully rediredted")
        }
    }
}

@kotlinx.serialization.Serializable
class person(val name: String, val age: Int)
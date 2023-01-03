package com.example

import com.example.repository.HeroRepository
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import kotlin.test.*
import io.ktor.server.testing.*
import org.koin.java.KoinJavaComponent.inject

class ApplicationTest {
    private val heroRepository:HeroRepository by inject(HeroRepository::class.java)
    @Test
    fun `access root endpoint, assert correct information`() = testApplication {
        application {
            Application::module
        }
        client.get("/").apply {
            assertEquals(
                expected =HttpStatusCode.OK,
                actual =status
            )
            assertEquals(
                expected = "welcome to the route Api",
                actual = bodyAsText()
            )
        }
    }



//    @Test
//    fun `access all heroes endpoint, assert correct information`()= testApplication{
//
//        application {
//            Application::module
//        }
//        client.get("/boruto/heroes").apply {
//            assertEquals(
//                expected =HttpStatusCode.OK,
//                actual =status
//            )
//            val expected=ApiResponse(
//                success = true,
//                message = "ok",
//                prevPage = null,
//                nextPage = 2,
//                heroes = heroRepository.page1,
//            )
//            val actual= Json.decodeFromString<ApiResponse>(bodyAsText())
//            assertEquals(
//                expected =expected,
//                actual = actual
//            )
//        }
//    }

}



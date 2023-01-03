package com.example.repository

import com.example.models.ApiResponse
import com.example.models.Hero

interface HeroRepository {
// key values will represent the page
    val heroes: Map<Int,List<Hero>>

    val page1: List<Hero>
    val page2: List<Hero>
    val page3: List<Hero>
    val page4: List<Hero>

    suspend fun getAllHeroes(page:Int):ApiResponse
    suspend fun searchHeroes(name:String?):ApiResponse



    val page5: List<Hero>
}

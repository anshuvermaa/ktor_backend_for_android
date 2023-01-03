package com.example.repository

import com.example.models.ApiResponse
import com.example.models.Hero


// this is old approach in which we have already made list (pages) with predefined number of items
// in new approach we put all our heroes in one list and dynamicly limiting all items

interface HeroRepository {
// key values will represent the page
    val heroes: Map<Int,List<Hero>>

    val page1: List<Hero>
    val page2: List<Hero>
    val page3: List<Hero>
    val page4: List<Hero>
    val page5: List<Hero>

    suspend fun getAllHeroes(page:Int):ApiResponse
    suspend fun searchHeroes(name:String?):ApiResponse



}

package com.sanmobi.bellyfood.data

import com.sanmobi.bellyfood.data.network.FoodRecipesApi
import com.sanmobi.bellyfood.models.FoodJoke
import com.sanmobi.bellyfood.models.FoodRecipe
import retrofit2.Response
import javax.inject.Inject

class RemoteDataSource @Inject constructor(
    private val foodRecipesApi: FoodRecipesApi
){

   suspend fun getRecipes(queries: Map<String,String>):Response<FoodRecipe> {
        return foodRecipesApi.getRecipes(queries)
    }

    suspend fun searchRecipes(searchQueries: Map<String,String>):Response<FoodRecipe> {
        return foodRecipesApi.searchRecipes(searchQueries)
    }

    suspend fun  getFoodJoke(apiKey: String): Response<FoodJoke> {
        return foodRecipesApi.getFoodKJoke(apiKey)
    }

}
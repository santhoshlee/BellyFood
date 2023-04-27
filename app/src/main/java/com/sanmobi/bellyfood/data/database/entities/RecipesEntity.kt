package com.sanmobi.bellyfood.data.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.sanmobi.bellyfood.models.FoodRecipe
import com.sanmobi.bellyfood.util.Constants.Companion.RECIPES_TABLE

@Entity(tableName = RECIPES_TABLE)
class RecipesEntity (
    var foodRecipe: FoodRecipe
        )
{
    @PrimaryKey(autoGenerate = false)
    var id: Int = 0
}
package com.sanmobi.bellyfood.data.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.sanmobi.bellyfood.util.Constants.Companion.FAVORITE_RECIPES_TABLE
import com.sanmobi.bellyfood.models.Result

@Entity(tableName = FAVORITE_RECIPES_TABLE)
class FavoritesEntity (
    @PrimaryKey(autoGenerate = true)
    var id: Int,
    var result: Result
)
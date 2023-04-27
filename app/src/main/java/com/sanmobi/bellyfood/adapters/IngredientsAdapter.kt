package com.sanmobi.bellyfood.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.sanmobi.bellyfood.R
import com.sanmobi.bellyfood.models.ExtendedIngredient
import com.sanmobi.bellyfood.util.Constants.Companion.BASE_IMAGE_URL
import com.sanmobi.bellyfood.util.RecipesDiffUtil
import kotlinx.android.synthetic.main.ingredients_row_layout.view.*
import java.util.*

class IngredientsAdapter: RecyclerView.Adapter<IngredientsAdapter.MyViewHolder>() {

    private var ingredientList = emptyList<ExtendedIngredient>()

    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.ingredients_row_layout, parent, false))
    }

    override fun getItemCount(): Int {
        return ingredientList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        holder.itemView.ingredient_imageView.load(BASE_IMAGE_URL + ingredientList[position].image) {
            crossfade(600)
            error(R.drawable.ic_error_placeholder)
        }

        holder.itemView.ingredient_name.text = ingredientList[position].name.capitalize(Locale.ROOT)
        holder.itemView.ingredient_amount.text = ingredientList[position].amount.toString()
        holder.itemView.ingredient_unit.text = ingredientList[position].unit
        holder.itemView.ingredient_consistency.text = ingredientList[position].consistency
        holder.itemView.ingredient_original.text = ingredientList[position].original

    }

    fun setData(newIngredients: List<ExtendedIngredient>) {
        val ingredientDiffUtil =
            RecipesDiffUtil(ingredientList, newIngredients)
        val diffUtilResult = DiffUtil.calculateDiff(ingredientDiffUtil)
        ingredientList = newIngredients
        diffUtilResult.dispatchUpdatesTo(this)
    }

}
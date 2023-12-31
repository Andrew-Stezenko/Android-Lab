package com.example.myapplication

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.myapplication.databinding.ItemListBinding

class RecipeAdapter(
    val onClick: (recipe: Recipe, position: Int) -> Unit
) : RecyclerView.Adapter<RecipeAdapter.RecipeViewHolder>() {

    private val list = ArrayList<Recipe>()

    fun setList(newList: List<Recipe>) {
        list.clear()
        list.addAll(newList)
        notifyDataSetChanged()
    }

    inner class RecipeViewHolder(val binding: ItemListBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(element: Recipe, position: Int) {

            binding.tvName.text = element.name
            val str = binding.tvDesc.context.getString(R.string.description) + element.author
            binding.tvDesc.text = str
            binding.btn.setOnClickListener {
                onClick(element, position)
            }


            Glide.with(binding.iv.context)
                .load("https://i.imgur.com/ApeMcHR.jpeg")
                .centerInside()
                .into(binding.iv)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipeViewHolder {
        val binding = ItemListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return RecipeViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: RecipeViewHolder, position: Int) {
        val element = list[position]
        holder.bind(element, position)
    }

    fun setNewData(it: List<Animal>?) {

    }
}
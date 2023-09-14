package com.local.androidapp.adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.local.androidapp.R
import com.local.androidapp.models.GridItem

class GridAdapter(
    private val items: List<GridItem>,
    private val onClick: ((GridItem) -> Unit)? = null // <-- Click event
) : RecyclerView.Adapter<GridAdapter.GridViewHolder>() {

    inner class GridViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val name: TextView = view.findViewById(R.id.grid_item_name)
        val image: ImageView = view.findViewById(R.id.grid_item_image)

        // Initialize item click listener
        init {
            view.setOnClickListener {
                val position = bindingAdapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    onClick?.invoke(items[position])
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GridViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.grid_item, parent, false)
        return GridViewHolder(view)
    }

    override fun onBindViewHolder(holder: GridViewHolder, position: Int) {
        Log.d("GridAdapter", "Binding view holder at position $position")
        val item = items[position]
        holder.name.text = item.name
        holder.image.setImageResource(item.imageResourceId)
    }

    override fun getItemCount() = items.size
}

package com.example.homewordroman.adapter

import com.example.homewordroman.data.AlbumId
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.homewordroman.data.ResultApi
import com.example.homewordroman.databinding.ItemLayoutBinding

class HomeAdapter(
    private var album : List<AlbumId?>
):RecyclerView.Adapter<HomeAdapter.MyViewHolder>() {



     fun setItems(results: List<AlbumId>){
        album = results
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeAdapter.MyViewHolder {
        val binding = ItemLayoutBinding.inflate(LayoutInflater.from(parent.context), parent,false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: HomeAdapter.MyViewHolder, position: Int) {
        if (album[position] != null){
            holder.binding.albumName.text = album[position]?.title

            Glide.with(holder.itemView.context)
                .load(album[position]?.url)
                .into(holder.binding.imageView)

            Glide.with(holder.itemView.context)
                .load(album[position]?.thumbnailUrl)
                .into(holder.binding.titlePhoto)
        }
    }

    override fun getItemCount(): Int {
    return album.size
    }


    inner class MyViewHolder(val binding: ItemLayoutBinding ) : RecyclerView.ViewHolder(binding.root)

}
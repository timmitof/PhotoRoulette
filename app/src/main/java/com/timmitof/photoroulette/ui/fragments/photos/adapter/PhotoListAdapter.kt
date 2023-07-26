package com.timmitof.photoroulette.ui.fragments.photos.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.timmitof.photoroulette.data.models.Photo
import com.timmitof.photoroulette.data.models.Src
import com.timmitof.photoroulette.databinding.PhotoItemBinding

class PhotoListAdapter(private val onClickDetails: (Src) -> Unit): PagingDataAdapter<Photo, PhotoListAdapter.PhotoViewHolder>(PhotoComparator) {

    inner class PhotoViewHolder(private val binding: PhotoItemBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(photo: Photo?) {
            Glide.with(binding.root).load(photo?.src?.portrait).into(binding.imageView)
            binding.imageView.setOnClickListener {
                photo?.src?.let { src -> onClickDetails.invoke(src) }
            }
        }
    }

    override fun onBindViewHolder(holder: PhotoViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoViewHolder {
        return PhotoViewHolder(
            PhotoItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false,
            )
        )
    }
}
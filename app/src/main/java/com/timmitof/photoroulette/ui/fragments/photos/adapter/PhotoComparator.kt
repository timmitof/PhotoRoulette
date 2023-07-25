package com.timmitof.photoroulette.ui.fragments.photos.adapter

import androidx.recyclerview.widget.DiffUtil
import com.timmitof.photoroulette.data.models.Photo

object PhotoComparator : DiffUtil.ItemCallback<Photo>() {
    override fun areItemsTheSame(oldItem: Photo, newItem: Photo): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Photo, newItem: Photo): Boolean {
        return oldItem == newItem
    }

}
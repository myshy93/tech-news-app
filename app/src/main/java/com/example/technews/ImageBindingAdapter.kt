package com.example.technews

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.squareup.picasso.Picasso

object ImageBindingAdapter {
    @JvmStatic
    @BindingAdapter("bind:imageSrc")
    fun loadImage(view: ImageView, imageUrl: String?) {
        Picasso.with(view.context)
            .load(imageUrl)
            .placeholder(R.drawable.ic_launcher_background)
            .into(view)
    }
}
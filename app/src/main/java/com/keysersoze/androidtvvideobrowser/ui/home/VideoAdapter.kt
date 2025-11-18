package com.keysersoze.androidtvvideobrowser.ui.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.keysersoze.androidtvvideobrowser.databinding.ItemVideoBinding
import com.keysersoze.androidtvvideobrowser.domain.VideoItem

class VideoAdapter(
    private val items: List<VideoItem>,
    private val onClick: (VideoItem, Int) -> Unit
) : RecyclerView.Adapter<VideoAdapter.VideoViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VideoViewHolder {
        val binding = ItemVideoBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return VideoViewHolder(binding)
    }

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: VideoViewHolder, position: Int) {
        holder.bind(items[position], position)
    }

    inner class VideoViewHolder(private val binding: ItemVideoBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: VideoItem, position: Int) {

            Glide.with(binding.thumbnail)
                .load(item.thumbnail)
                .into(binding.thumbnail)

            binding.title.text = item.title

            val root = binding.rootItem
            val glow = binding.focusGlow

            root.isFocusable = true
            root.isFocusableInTouchMode = true

            root.setOnFocusChangeListener { v, hasFocus ->
                v.animate()
                    .scaleX(if (hasFocus) 1.02f else 1f)
                    .scaleY(if (hasFocus) 1.02f else 1f)
                    .setDuration(150)
                    .start()

                glow.animate()
                    .alpha(if (hasFocus) 1f else 0f)
                    .setDuration(150)
                    .withStartAction {
                        if (hasFocus) glow.visibility = View.VISIBLE
                    }
                    .withEndAction {
                        if (!hasFocus) glow.visibility = View.INVISIBLE
                    }
                    .start()
            }

            root.setOnClickListener {
                onClick(item, position)
            }
        }
    }
}
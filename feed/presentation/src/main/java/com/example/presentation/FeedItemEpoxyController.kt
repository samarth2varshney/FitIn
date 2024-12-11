package com.example.presentation

import com.airbnb.epoxy.TypedEpoxyController
import com.bumptech.glide.Glide
import com.example.presentation.databinding.FeedItemBinding
import com.example.util.ViewBindingKotlinModel

class FeedItemEpoxyController(private val callback: (() -> Unit)):TypedEpoxyController<List<FeedItem>>() {

    override fun buildModels(data: List<FeedItem>?) {
        if(data.isNullOrEmpty()){
            return
        }
        data.forEach{ feedItem ->
            ItemEpoxyModel(callback,feedItem.imageUrl,feedItem.influencerName,feedItem.likes,feedItem.comments).id(feedItem.id).addTo(this)
        }
    }

    data class ItemEpoxyModel(
        private val callback: (() -> Unit),
        val imageUrl:String,
        val influencerName:String,
        val likes:String,
        val comments:String
    ): ViewBindingKotlinModel<FeedItemBinding>(R.layout.feed_item) {

        override fun FeedItemBinding.bind() {

            Glide
                .with(postImage.context)
                .load(imageUrl)
                .error(R.drawable.ic_launcher_foreground)
                .into(postImage)

            author.text = influencerName
            noOfLikes.text = likes
            noOfComments.text = comments

            comment.setOnClickListener {
                callback.invoke()
            }

            like.setOnClickListener {
                val isLiked = like.tag as? Boolean ?: false
                if (isLiked) {
                    like.setImageResource(R.drawable.ic_like)
                    like.tag = false
                } else {
                    like.setImageResource(R.drawable.ic_liked)
                    like.tag = true
                }
            }

            save.setOnClickListener {
                val isSaved = save.tag as? Boolean ?: false
                if (isSaved) {
                    save.setImageResource(R.drawable.ic_save)
                    save.tag = false
                } else {
                    save.setImageResource(R.drawable.ic_save_black)
                    save.tag = true
                }
            }

        }

    }

}
package com.example.presentation

import com.airbnb.epoxy.TypedEpoxyController
import com.bumptech.glide.Glide
import com.example.presentation.databinding.RankingItemBinding
import com.example.util.ViewBindingKotlinModel

class RankingEpoxyControl: TypedEpoxyController<List<RankingItem>>() {

    override fun buildModels(data: List<RankingItem>?) {
        if(data.isNullOrEmpty()){
            return
        }

        val sortedData = data.sortedWith(compareByDescending<RankingItem> { it.likes.toInt() }
            .thenByDescending { it.comments.toInt() })

        sortedData.forEach{ feedItem ->
            RankingEpoxyModel(feedItem.imageUrl,feedItem.influencerName,feedItem.likes,feedItem.comments).id(feedItem.id).addTo(this)
        }
    }

    data class RankingEpoxyModel(
        val imageUrl: String,
        val influencerName:String,
        val likes:String,
        val comments:String
    ): ViewBindingKotlinModel<RankingItemBinding>(R.layout.ranking_item){
        override fun RankingItemBinding.bind() {

            Glide
                .with(postImage.context)
                .load(imageUrl)
                .error(com.example.util.R.drawable.ic_launcher_foreground)
                .into(postImage)

            author.text = influencerName
            noOfLikes.text = likes
            noOfComments.text = comments

            like.setOnClickListener {
                val isLiked = like.tag as? Boolean ?: false
                if (isLiked) {
                    like.setImageResource(com.example.util.R.drawable.ic_like)
                    like.tag = false
                } else {
                    like.setImageResource(com.example.util.R.drawable.ic_liked)
                    like.tag = true
                }
            }

            save.setOnClickListener {
                val isSaved = save.tag as? Boolean ?: false
                if (isSaved) {
                    save.setImageResource(com.example.util.R.drawable.ic_save)
                    save.tag = false
                } else {
                    save.setImageResource(com.example.util.R.drawable.ic_save_black)
                    save.tag = true
                }
            }
        }

    }
}
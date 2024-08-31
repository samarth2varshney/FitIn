package com.example.fitin.ui.home.feed

import com.airbnb.epoxy.TypedEpoxyController
import com.example.fitin.R
import com.example.fitin.ViewBindingKotlinModel
import com.example.fitin.data.remote.FeedItem
import com.example.fitin.databinding.FeedItemBinding

class FeedItemEpoxyController:TypedEpoxyController<List<FeedItem>>() {

    override fun buildModels(data: List<FeedItem>?) {
        if(data.isNullOrEmpty()){
            return
        }
        data.forEach{ feedItem ->
            ItemEpoxyModel(feedItem.imageUrl,feedItem.influencerName,feedItem.likes,feedItem.views).id(1).addTo(this)
        }
    }

    data class ItemEpoxyModel(
        val imageUrl:String,
        val influencerName:String,
        val likes:String,
        val views:String
    ): ViewBindingKotlinModel<FeedItemBinding>(R.layout.feed_item) {

        override fun FeedItemBinding.bind() {

            textView.text = influencerName

        }

    }

}
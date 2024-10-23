package com.example.fitin.ui

import com.airbnb.epoxy.TypedEpoxyController
import com.example.fitin.R
import com.example.fitin.ViewBindingKotlinModel
import com.example.fitin.data.remote.CommentItem
import com.example.fitin.databinding.CommentsItemBinding
import com.example.fitin.databinding.FeedItemBinding

class CommentsEpoxyController:TypedEpoxyController<List<CommentItem>>() {

    override fun buildModels(data: List<CommentItem>?) {
        if(data.isNullOrEmpty()){
            return
        }
        data.forEach { item->
            CommentsEpoxyModel(item).id(item.id).addTo(this)
        }
    }

    data class CommentsEpoxyModel(
        val item: CommentItem
    ): ViewBindingKotlinModel<CommentsItemBinding>(R.layout.comments_item){

        override fun CommentsItemBinding.bind() {

            comment.text = item.comment
            userName.text = item.userName
            noOfLikes.text = item.noOfLikes

        }

    }


}
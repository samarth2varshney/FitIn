package com.example.presentation.comments

import com.airbnb.epoxy.TypedEpoxyController
import com.example.presentation.CommentItem
import com.example.presentation.R
import com.example.presentation.databinding.CommentsItemBinding
import com.example.util.ViewBindingKotlinModel

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
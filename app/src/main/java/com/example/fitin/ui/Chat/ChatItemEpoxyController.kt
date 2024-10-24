package com.example.fitin.ui.Chat

import com.airbnb.epoxy.TypedEpoxyController
import com.bumptech.glide.Glide
import com.example.fitin.R
import com.example.fitin.ViewBindingKotlinModel
import com.example.fitin.data.remote.ChatItem
import com.example.fitin.databinding.ChatItemBinding

class ChatItemEpoxyController(private val callback:(()->Unit)): TypedEpoxyController<List<ChatItem>>() {

    override fun buildModels(data: List<ChatItem>?) {
        if(data.isNullOrEmpty()){
            return
        }
        data.forEach{
            ChatEpoxyModel(callback,it).id(1).addTo(this)
        }
    }

    data class ChatEpoxyModel(
        private val callback:(()->Unit),
        val item:ChatItem
    ): ViewBindingKotlinModel<ChatItemBinding>(R.layout.chat_item) {

        override fun ChatItemBinding.bind() {

            root.setOnClickListener {
                callback.invoke()
            }

            Glide.with(root)
                .load(item.image)
                .into(profileImage)

            userName.text = item.name

        }

    }

}
package com.example.fitin.ui.Chat.messaging

import com.airbnb.epoxy.TypedEpoxyController
import com.bumptech.glide.Glide
import com.example.fitin.R
import com.example.fitin.ViewBindingKotlinModel
import com.example.fitin.data.remote.ChatItem
import com.example.fitin.data.remote.Message
import com.example.fitin.databinding.ChatItemBinding
import com.example.fitin.databinding.ItemReceivedMessageBinding
import com.example.fitin.databinding.ItemSentMessageBinding

class MessageItemEpoxyController(): TypedEpoxyController<List<Message>>() {

    override fun buildModels(messages: List<Message>?) {
        if(messages.isNullOrEmpty()){
            return
        }
        messages.forEachIndexed { index, message ->
            if (message.isSent) {
                SentMessageModel(message.text).id(1).addTo(this)
            } else {
                ReceivedMessageModel(message.text).id(1).addTo(this)
            }
        }
    }

    data class SentMessageModel(
        val message: String
    ): ViewBindingKotlinModel<ItemSentMessageBinding>(R.layout.item_sent_message) {

        override fun ItemSentMessageBinding.bind() {

            sentMessageText.text = message

        }

    }

    data class ReceivedMessageModel(
        val message: String
    ): ViewBindingKotlinModel<ItemReceivedMessageBinding>(R.layout.item_received_message) {

        override fun ItemReceivedMessageBinding.bind() {

            receivedMessageText.text = message

        }

    }

}
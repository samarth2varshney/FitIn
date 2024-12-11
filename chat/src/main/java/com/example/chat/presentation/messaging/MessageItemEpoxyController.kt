package com.example.chat.presentation.messaging

import com.airbnb.epoxy.TypedEpoxyController
import com.example.chat.data.remote.Message
import com.example.chat.R
import com.example.chat.databinding.ItemReceivedMessageBinding
import com.example.chat.databinding.ItemSentMessageBinding
import com.example.util.ViewBindingKotlinModel

class MessageItemEpoxyController: TypedEpoxyController<List<Message>>() {

    override fun buildModels(messages: List<Message>?) {
        if(messages.isNullOrEmpty()){
            return
        }
        messages.forEachIndexed { _, message ->
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
package com.example.presentation

import com.airbnb.epoxy.TypedEpoxyController
import com.bumptech.glide.Glide
import com.example.presentation.databinding.ItemInfluencerPlanBinding
import com.example.util.ViewBindingKotlinModel

class PlanItemEpoxyControl(private val callback:(()->Unit)): TypedEpoxyController<List<PlanItem>>() {

    override fun buildModels(data: List<PlanItem>?) {
        if(data.isNullOrEmpty()){
            return
        }
        data.forEach{ PlanItem ->
            PlanEpoxyModel(callback,PlanItem.planName,PlanItem.planDescription,PlanItem.imageUrl,PlanItem.suscribersNo, PlanItem.planPrice, PlanItem.isBookMarked).id(PlanItem.id).addTo(this)
        }
    }

    data class PlanEpoxyModel(
        private val callback:(()->Unit),
        val planName:String,
        val planDescription:String,
        val imageUrl:String,
        val suscribers:String,
        val planPrice: String,
        var isBookMarked: Boolean
    ): ViewBindingKotlinModel<ItemInfluencerPlanBinding>(R.layout.item_influencer_plan) {

        override fun ItemInfluencerPlanBinding.bind() {

            root.setOnClickListener {
                callback.invoke()
            }

            Glide
                .with(planImage.context)
                .load(imageUrl)
                .error(com.example.util.R.drawable.ic_launcher_foreground)
                .into(planImage)

            planTitle.text = planName
            planDescription.text = planDescription.text.toString()
            planSuscribers.text = suscribers
            planPrice.text = planPrice.text.toString()

            imageBookmark.setOnClickListener {
                if(isBookMarked){
                    imageBookmark.setImageResource(com.example.util.R.drawable.ic_save)
                    isBookMarked = false
                } else {
                    imageBookmark.setImageResource(com.example.util.R.drawable.ic_save_black)
                    isBookMarked = true
                }
            }
        }

    }

}
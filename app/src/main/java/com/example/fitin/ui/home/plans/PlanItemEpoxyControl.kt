package com.example.fitin.ui.home.plans

import com.airbnb.epoxy.TypedEpoxyController
import com.bumptech.glide.Glide
import com.example.fitin.R
import com.example.fitin.ViewBindingKotlinModel
import com.example.fitin.data.remote.PlanItem
import com.example.fitin.databinding.ItemInfluencerPlanBinding

class PlanItemEpoxyControl: TypedEpoxyController<List<PlanItem>>() {

    override fun buildModels(data: List<PlanItem>?) {
        if(data.isNullOrEmpty()){
            return
        }
        data.forEach{ PlanItem ->
            PlanEpoxyModel(PlanItem.planName,PlanItem.planDescription,PlanItem.imageUrl,PlanItem.suscribersNo, PlanItem.planPrice).id(PlanItem.id).addTo(this)
        }
    }

    data class PlanEpoxyModel(
        val planName:String,
        val planDescription:String,
        val imageUrl:String,
        val suscribers:String,
        val planPrice: String
    ): ViewBindingKotlinModel<ItemInfluencerPlanBinding>(R.layout.item_influencer_plan) {

        override fun ItemInfluencerPlanBinding.bind() {

            Glide
                .with(planImage.context)
                .load(imageUrl)
                .error(R.drawable.ic_launcher_foreground)
                .into(planImage)

            planTitle.text = planName
            planDescription.text = planDescription.text.toString()
            planSuscribers.text = suscribers
            planPrice.text = planPrice.text.toString()



        }

    }

}
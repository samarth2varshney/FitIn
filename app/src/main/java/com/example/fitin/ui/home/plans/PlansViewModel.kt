package com.example.fitin.ui.home.plans

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.fitin.data.remote.PlanItem

class PlansViewModel : ViewModel() {
    private val _planList = MutableLiveData<List<PlanItem>>()

    init {
        setFeedList(listOf(
            PlanItem(1,"1","Yash","https://firebasestorage.googleapis.com/v0/b/varsfit.appspot.com/o/pic1.jpg?alt=media&token=ca849b15-5f77-4a9c-8bbe-865b64da5b4f","10","100", false),
            PlanItem(2,"2","simrankaurpurewal","https://firebasestorage.googleapis.com/v0/b/varsfit.appspot.com/o/pic2.jpg?alt=media&token=caa2315d-4757-416f-8b36-af52e2a047c0","10","100", false),
            PlanItem(3,"3","yash anand","https://firebasestorage.googleapis.com/v0/b/varsfit.appspot.com/o/pic3.jpg?alt=media&token=2deb9847-6a65-4592-80e6-dbb0c72c3c94","10","100", false),
            PlanItem(4,"4","aesruf","https://firebasestorage.googleapis.com/v0/b/varsfit.appspot.com/o/pic2.jpg?alt=media&token=caa2315d-4757-416f-8b36-af52e2a047c0","10","100", false),
            PlanItem(5,"5","fearlesssher","https://firebasestorage.googleapis.com/v0/b/varsfit.appspot.com/o/pic1.jpg?alt=media&token=ca849b15-5f77-4a9c-8bbe-865b64da5b4f","10","100", false)
        ))
    }

    // Expose the list as LiveData
    val planList: LiveData<List<PlanItem>> get() = _planList

    fun setFeedList(newList: List<PlanItem>) {
        _planList.value = newList
    }
}
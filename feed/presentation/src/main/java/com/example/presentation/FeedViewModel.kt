package com.example.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.util.Data.img1
import com.example.util.Data.img2
import com.example.util.Data.img3
import com.example.util.Data.img4

class FeedViewModel : ViewModel() {

    private val _feedList = MutableLiveData<List<FeedItem>>()

    // Expose the list as LiveData
    val feedList: LiveData<List<FeedItem>> get() = _feedList

    init {
        setFeedList(listOf(
            FeedItem(1, img4,"Yash","10","100"),
            FeedItem(2, img1,"simrankaurpurewal","10","100"),
            FeedItem(3, img2,"yash anand","10","100"),
            FeedItem(4, img3,"aesruf","10","100"),
            FeedItem(5, img4,"fearlesssher","10","100")
        ))
    }

    fun setFeedList(newList: List<FeedItem>) {
        _feedList.value = newList
    }

}
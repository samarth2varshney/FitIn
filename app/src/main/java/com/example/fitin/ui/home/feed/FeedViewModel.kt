package com.example.fitin.ui.home.feed

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.fitin.data.remote.FeedItem

class FeedViewModel : ViewModel() {

    private val _feedList = MutableLiveData<List<FeedItem>>()

    // Expose the list as LiveData
    val feedList: LiveData<List<FeedItem>> get() = _feedList

    init {
        setFeedList(listOf(
            FeedItem(1,"https://firebasestorage.googleapis.com/v0/b/varsfit.appspot.com/o/pic1.jpg?alt=media&token=ca849b15-5f77-4a9c-8bbe-865b64da5b4f","Yash","10","100"),
            FeedItem(2,"https://firebasestorage.googleapis.com/v0/b/varsfit.appspot.com/o/pic2.jpg?alt=media&token=caa2315d-4757-416f-8b36-af52e2a047c0","simrankaurpurewal","10","100"),
            FeedItem(3,"https://firebasestorage.googleapis.com/v0/b/varsfit.appspot.com/o/pic3.jpg?alt=media&token=2deb9847-6a65-4592-80e6-dbb0c72c3c94","yash anand","10","100"),
            FeedItem(4,"https://firebasestorage.googleapis.com/v0/b/varsfit.appspot.com/o/pic1.jpg?alt=media&token=ca849b15-5f77-4a9c-8bbe-865b64da5b4f","aesruf","10","100"),
            FeedItem(5,"https://firebasestorage.googleapis.com/v0/b/varsfit.appspot.com/o/pic3.jpg?alt=media&token=2deb9847-6a65-4592-80e6-dbb0c72c3c94","fearlesssher","10","100")
        ))
    }

    fun setFeedList(newList: List<FeedItem>) {
        _feedList.value = newList
    }

}
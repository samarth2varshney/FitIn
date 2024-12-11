package com.example.search

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.util.Data.img1
import com.example.util.Data.img2
import com.example.util.Data.img3
import com.example.util.Data.img4
import com.example.util.Data.liveStreamVideoUrl

class SearchViewModel : ViewModel() {
    private val _searchList = MutableLiveData<List<SearchItem>>()

    init {
        setSearchList(listOf(
            SearchItem(0,img1,img2,img3,img4, liveStreamVideoUrl),
            SearchItem(0,img1,img2,img3,img4,liveStreamVideoUrl),
            SearchItem(0,img1,img2,img3,img4,liveStreamVideoUrl),
            SearchItem(0,img1,img2,img3,img4,liveStreamVideoUrl)
        ))
    }

    // Expose the list as LiveData
    val searchList: LiveData<List<SearchItem>> get() = _searchList

    fun setSearchList(newList: List<SearchItem>) {
        _searchList.value = newList
    }
}
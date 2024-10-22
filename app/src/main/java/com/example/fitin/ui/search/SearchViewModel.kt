package com.example.fitin.ui.search

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.fitin.data.Data.img1
import com.example.fitin.data.Data.img2
import com.example.fitin.data.Data.img3
import com.example.fitin.data.Data.img4
import com.example.fitin.data.Data.liveStreamVideoUrl
import com.example.fitin.data.remote.SearchItem

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
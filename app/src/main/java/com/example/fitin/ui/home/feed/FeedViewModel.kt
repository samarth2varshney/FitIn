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
            FeedItem(1,"https://scontent-del1-1.cdninstagram.com/v/t39.30808-6/457798007_18452880007007330_607956298020227910_n.jpg?stp=dst-jpg_e35&efg=eyJ2ZW5jb2RlX3RhZyI6ImltYWdlX3VybGdlbi4xNDQweDE3OTYuc2RyLmYzMDgwOC5kZWZhdWx0X2ltYWdlIn0&_nc_ht=scontent-del1-1.cdninstagram.com&_nc_cat=102&_nc_ohc=3tca9f5Zc9oQ7kNvgFqBL8v&edm=AEhyXUkAAAAA&ccb=7-5&ig_cache_key=MzQ0Njc4NDQ4MzczMzg5NjgwMw%3D%3D.2-ccb7-5&oh=00_AYB2BDpIRmPLkm6XvMcHRqJmB3YA1x9Kb2ZPmX8qNZW_8Q&oe=66D8D72E&_nc_sid=8f1549","Yash","10","100"),
            FeedItem(2,"https://scontent-del1-2.cdninstagram.com/v/t51.29350-15/432179372_371342099150164_1077263762092230560_n.jpg?stp=dst-jpg_e35&efg=eyJ2ZW5jb2RlX3RhZyI6ImltYWdlX3VybGdlbi4xNDQweDE3OTkuc2RyLmYyOTM1MC5kZWZhdWx0X2ltYWdlIn0&_nc_ht=scontent-del1-2.cdninstagram.com&_nc_cat=104&_nc_ohc=YesJF2htaAMQ7kNvgHrhfbb&edm=AFg4Q8wBAAAA&ccb=7-5&ig_cache_key=MzMxOTA5MzA5MDYwMjE3NTQ2Mg%3D%3D.2-ccb7-5&oh=00_AYDZWlIfpRXz10Cx1LdV2SWlnkzLfqtdXlHEDU90qIfrzw&oe=66D8F098&_nc_sid=0b30b7","simrankaurpurewal","10","100"),
            FeedItem(3,"https://scontent-del1-2.cdninstagram.com/v/t39.30808-6/456455836_18453228598030216_1408753105403381021_n.jpg?stp=dst-jpg_e35&efg=eyJ2ZW5jb2RlX3RhZyI6ImltYWdlX3VybGdlbi4xNDQweDE4MDAuc2RyLmYzMDgwOC5kZWZhdWx0X2ltYWdlIn0&_nc_ht=scontent-del1-2.cdninstagram.com&_nc_cat=1&_nc_ohc=wivXeDC4Pw4Q7kNvgE9EXSL&edm=AEhyXUkAAAAA&ccb=7-5&ig_cache_key=MzQzODg1MzA1NDIzMTY5OTU4MQ%3D%3D.2-ccb7-5&oh=00_AYD87ZCrFZxyVSSn5FUEQhUtd8aWthcCj899F1y0mrUVMA&oe=66D8E0E0&_nc_sid=8f1549","yash anand","10","100"),
            FeedItem(4,"https://scontent-del1-2.cdninstagram.com/v/t51.29350-15/451051238_452875254245148_2032441153719012190_n.jpg?stp=dst-jpg_e35&efg=eyJ2ZW5jb2RlX3RhZyI6ImltYWdlX3VybGdlbi4xNDQweDE4MDAuc2RyLmYyOTM1MC5kZWZhdWx0X2ltYWdlIn0&_nc_ht=scontent-del1-2.cdninstagram.com&_nc_cat=100&_nc_ohc=UoRq5ObuOpMQ7kNvgHonQR3&edm=AEhyXUkBAAAA&ccb=7-5&ig_cache_key=MzQxMzQzMjgyODE5Mzc1MDQzMQ%3D%3D.2-ccb7-5&oh=00_AYB4-hql8g7bgOBjCq9Mc0X_Z5bShE_oRIfiPakB5GSB8g&oe=66D8E5C1&_nc_sid=8f1549","aesruf","10","100"),
            FeedItem(5,"https://scontent-del2-1.cdninstagram.com/v/t39.30808-6/457508948_18331492393182345_7277123280765951851_n.jpg?stp=dst-jpg_e35&efg=eyJ2ZW5jb2RlX3RhZyI6ImltYWdlX3VybGdlbi4xNDQweDE4MDAuc2RyLmYzMDgwOC5kZWZhdWx0X2ltYWdlIn0&_nc_ht=scontent-del2-1.cdninstagram.com&_nc_cat=109&_nc_ohc=W9Jg2YN2g5gQ7kNvgHDDkMD&edm=AEhyXUkAAAAA&ccb=7-5&ig_cache_key=MzQ0NTMxNDYxNDM1ODM1NDU1Mg%3D%3D.2-ccb7-5&oh=00_AYALMxg-yMOqAB2WB3ZkLy9k-9R8asYxFvhw4i4FEg5q_Q&oe=66D8FCAE&_nc_sid=8f1549","fearlesssher","10","100")
        ))
    }

    fun setFeedList(newList: List<FeedItem>) {
        _feedList.value = newList
    }

}
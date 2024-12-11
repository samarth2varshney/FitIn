package com.example.search

import android.net.Uri
import android.util.Log
import android.view.Gravity
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.PopupWindow
import com.airbnb.epoxy.TypedEpoxyController
import com.bumptech.glide.Glide
import com.example.search.databinding.SearchItemBinding
import com.example.util.ViewBindingKotlinModel
import com.google.android.exoplayer2.ExoPlayer
import com.google.android.exoplayer2.MediaItem
import com.google.android.exoplayer2.PlaybackException
import com.google.android.exoplayer2.Player
import com.google.android.exoplayer2.ui.PlayerView

class SearchItemEpoxyController:TypedEpoxyController<List<SearchItem>>() {

    private var isLongPressActive = false
    private var onLongPressListener: ((Boolean) -> Unit)? = null

    override fun buildModels(data: List<SearchItem>?) {
        if(data.isNullOrEmpty()){
            return
        }
        data.forEachIndexed { index, searchItem ->
            if (index % 2 == 0) {
                ItemEpoxyModel(
                    searchItem.imageUrl1, searchItem.imageUrl2,
                    searchItem.imageUrl3, searchItem.imageUrl4,
                    searchItem.videoUrl, isContainer1 = true,
                    onLongPress = { active ->
                        isLongPressActive = active
                        onLongPressListener?.invoke(active)
                    }
                ).id(searchItem.id).addTo(this)
            } else {
                ItemEpoxyModel(
                    searchItem.imageUrl1, searchItem.imageUrl2,
                    searchItem.imageUrl3, searchItem.imageUrl4,
                    searchItem.videoUrl, isContainer1 = false,
                    onLongPress = { active ->
                        isLongPressActive = active
                        onLongPressListener?.invoke(active)
                    }
                ).id(searchItem.id).addTo(this)
            }
        }
    }

    fun setOnLongPressListener(listener: (Boolean) -> Unit) {
        onLongPressListener = listener
    }

    data class ItemEpoxyModel(
        val imageUrl1: String,
        val imageUrl2: String,
        val imageUrl3: String,
        val imageUrl4: String,
        val videoUrl: String,
        val isContainer1: Boolean,
        val onLongPress: (Boolean) -> Unit
    ): ViewBindingKotlinModel<SearchItemBinding>(R.layout.search_item) {
        override fun SearchItemBinding.bind() {

            if (isContainer1) {
                container1.visibility = View.VISIBLE
                container2.visibility = View.GONE

                load(imageLeft1, imageUrl1)
                load(imageLeft2, imageUrl2)
                load(imageLeft3, imageUrl3)
                load(imageLeft4, imageUrl4)

                val uri = Uri.parse("https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4")

                setupExoPlayer(videoRight1, "https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4")
            } else {
                container1.visibility = View.GONE
                container2.visibility = View.VISIBLE

                load(imageRight1, imageUrl1)
                load(imageRight2, imageUrl2)
                load(imageRight3, imageUrl3)
                load(imageRight4, imageUrl4)

                val uri = Uri.parse("https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4")

                setupExoPlayer(videoLeft1, "https://rr4---sn-qxaelner.googlevideo.com/videoplayback?expire=1725662707&ei=kzHbZrTDE8O2rtoP6rmpoAI&ip=2001%3A448a%3A11b0%3A1f9e%3Ad74%3Af9a7%3Af90d%3A1a2a&id=o-AHExtDgP2vuBSGx6mQswIdSX9GT8NAzlsJSNlPyC45nw&itag=18&source=youtube&requiressl=yes&xpc=EgVo2aDSNQ%3D%3D&bui=AQmm2exfSTTdbKk2r2vrs7175u57hugmfpnAdbLYoxMUY4Kvs-T_Ys_GY2usQe_KLYE-69D9i2IUKFH6&spc=Mv1m9hqj0aEtIoQeFuu8desBuflkCf1S7HylByp2Mg15PM2BqowhUT0&vprv=1&svpuc=1&mime=video%2Fmp4&ns=OrksQz8sQI6Z2M2DqbHPqnIQ&rqh=1&gir=yes&clen=100952843&ratebypass=yes&dur=2487.298&lmt=1725617470906760&c=WEB_CREATOR&sefc=1&txp=3309224&n=CATqoKwEVCSsDQ&sparams=expire%2Cei%2Cip%2Cid%2Citag%2Csource%2Crequiressl%2Cxpc%2Cbui%2Cspc%2Cvprv%2Csvpuc%2Cmime%2Cns%2Crqh%2Cgir%2Cclen%2Cratebypass%2Cdur%2Clmt&sig=AJfQdSswRgIhAI0Kdrx1MKK05ryTkzs5FXGluUfVhw61qXAbDsX1HBtgAiEA9DkIJNp7Bx_vsQ-JngNRYIU72wmoKG1toGWic10rQaI%3D&title=The%20Uorfi%20Javed%20Roast%20Show%20%7C%20Munawar%20Faruqui%20%7C%20Ft.%20Kullu%2C%20Maheep%20Singh%2C%20Shreeja%20%26%20Raunaq%20Rajani&rm=sn-2uuxa3vh-3ovl76,sn-npo6s7s&rrc=79,104&fexp=24350516,24350518,24350557,24350561&req_id=2320500ba827a3ee&met=1725641265,&rms=rdu,rdu&redirect_counter=2&cms_redirect=yes&cmsv=e&hcs=ir&ipbypass=yes&mh=Yx&mip=220.158.168.165&mm=29&mn=sn-qxaelner&ms=rdu&mt=1725640864&mv=m&mvi=4&pl=24&lsparams=hcs,ipbypass,met,mh,mip,mm,mn,ms,mv,mvi,pl,rms&lsig=ABPmVW0wRQIhAPutGWk7PiDoCauIfEqLR3ZSQ-JMjJZfmXmDZ_0CnAobAiABqy3DcaPEh7WNe_j76t9lBJnqAGQuZLa7Ta81z45d-w%3D%3D")
            }

            imageLeft1.setOnLongClickListener {
                onLongPress(true)
                showPopup(imageUrl1, it, "image")
                true
            }
            imageLeft2.setOnLongClickListener {
                onLongPress(true)
                showPopup(imageUrl2, it, "image")
                true
            }
            imageLeft3.setOnLongClickListener {
                onLongPress(true)
                showPopup(imageUrl3, it, "image")
                true
            }
            imageLeft4.setOnLongClickListener {
                onLongPress(true)
                showPopup(imageUrl4, it, "image")
                true
            }
            videoRight1.setOnLongClickListener {
                onLongPress(true)
                showPopup(videoUrl, it, "video")
                true
            }

            imageRight1.setOnLongClickListener {
                onLongPress(true)
                showPopup(imageUrl1, it, "image")
                true
            }
            imageRight2.setOnLongClickListener {
                onLongPress(true)
                showPopup(imageUrl2, it, "image")
                true
            }
            imageRight3.setOnLongClickListener {
                onLongPress(true)
                showPopup(imageUrl3, it, "image")
                true
            }
            imageRight4.setOnLongClickListener {
                onLongPress(true)
                showPopup(imageUrl4, it, "image")
                true
            }
            videoLeft1.setOnLongClickListener {
                onLongPress(true)
                showPopup(videoUrl, it, "video")
                true
            }

        }

        private fun showPopup(mediaUrl: String, parent: View, type: String) {

            val popupView = LayoutInflater.from(parent.context).inflate(R.layout.search_feed_popup_window, null)
            val popupImage = popupView.findViewById<ImageView>(R.id.popup_image)
            val popupVideo = popupView.findViewById<PlayerView>(R.id.popup_video)

            if (type.equals("video")) {
                popupVideo.visibility = View.VISIBLE
                popupImage.visibility = View.GONE
                setupExoPlayer(popupVideo, mediaUrl)
            } else if(type.equals("image")){
                popupImage.visibility = View.VISIBLE
                popupVideo.visibility = View.GONE
                Glide.with(popupImage.context)
                    .load(mediaUrl)
                    .error(com.example.util.R.drawable.ic_launcher_foreground)
                    .into(popupImage)
            }

            val popupWindow = PopupWindow(popupView, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)
            popupWindow.isFocusable = true
            popupWindow.showAtLocation(parent, Gravity.CENTER, 0, 0)


            parent.setOnTouchListener { view, motionEvent ->
                when (motionEvent.action) {
                    MotionEvent.ACTION_MOVE -> {
                        return@setOnTouchListener true
                    }
                    MotionEvent.ACTION_UP -> {
                        popupWindow.dismiss()
                        onLongPress(false)
                        return@setOnTouchListener true
                    }
                    else -> return@setOnTouchListener false
                }
            }
        }

        private fun setupExoPlayer(playerView: PlayerView, videoUrl: String) {
            val player = ExoPlayer.Builder(playerView.context).build()
            playerView.player = player

            playerView.useController = false
            val mediaItem = MediaItem.fromUri(Uri.parse(videoUrl))
            player.setMediaItem(mediaItem)
            player.prepare()

            player.volume = 0f

            player.playWhenReady = true

            player.repeatMode = Player.REPEAT_MODE_ALL

            player.addListener(object : Player.Listener {
                override fun onPlayerError(error: PlaybackException) {
                    Log.e("ExoPlayer", "Player error: ${error.message}")
                }
            })

            playerView.addOnAttachStateChangeListener(object : View.OnAttachStateChangeListener {

                override fun onViewAttachedToWindow(p0: View) {
                    p0.visibility = View.VISIBLE
                }

                override fun onViewDetachedFromWindow(p0: View) {
                    p0.visibility = View.GONE
                    player.release()
                }
            })
        }

        private fun load(imageView: ImageView, url: String) {
            Glide.with(imageView.context)
                .load(url)
                .error(com.example.util.R.drawable.ic_launcher_foreground)
                .into(imageView)
        }

    }
}
package net.softglobe.videoviewtutorial

import android.net.Uri
import android.os.Bundle
import android.webkit.WebChromeClient
import android.webkit.WebView
import android.widget.MediaController
import android.widget.VideoView
import androidx.appcompat.app.AppCompatActivity
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val videoView = findViewById<VideoView>(R.id.video_view)
        val mediaController = MediaController(this)
        mediaController.setAnchorView(videoView)
        videoView.setMediaController(mediaController)
        videoView.setVideoURI(Uri.parse("android.resource://"+packageName+"/"+R.raw.video))

        val webView = findViewById<WebView>(R.id.web_view)
        webView.settings.javaScriptEnabled = true
        val path = "<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/AapEF9ZL6mw?si=XrGqqL8zj7NNo2Ra\" title=\"YouTube video player\" frameborder=\"0\" allow=\"accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share\" referrerpolicy=\"strict-origin-when-cross-origin\" allowfullscreen></iframe>"
        webView.webChromeClient = WebChromeClient()
        webView.loadData(path, "text/html", "UTF-8")

//        val youtubePlayerView = findViewById<YouTubePlayerView>(R.id.youtube_player_view)
//        youtubePlayerView.addYouTubePlayerListener(object : AbstractYouTubePlayerListener() {
//            override fun onReady(youTubePlayer: YouTubePlayer) {
//                super.onReady(youTubePlayer)
//                youTubePlayer.cueVideo("AapEF9ZL6mw", 0F)
//            }
//        })
    }
}
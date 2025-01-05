package net.softglobe.videoviewtutorial

import android.os.Bundle
import android.view.View
import android.widget.FrameLayout
import androidx.appcompat.app.AppCompatActivity
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.FullscreenListener
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.options.IFramePlayerOptions
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView


class MainActivity : AppCompatActivity() {
    lateinit var youTubePlayerView : YouTubePlayerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        youTubePlayerView = findViewById(R.id.youtube_player_view)
        lifecycle.addObserver(youTubePlayerView)
        youTubePlayerView.enableAutomaticInitialization = false

        val youTubePlayerListener = object : AbstractYouTubePlayerListener() {
            override fun onReady(youTubePlayer: YouTubePlayer) {
                super.onReady(youTubePlayer)
                youTubePlayer.cueVideo("AapEF9ZL6mw", 0F)
            }
        }

        val iFramePlayerOptions: IFramePlayerOptions = IFramePlayerOptions.Builder()
            .controls(1) // enable full screen button
            .fullscreen(1)
            .build()

        youTubePlayerView.initialize(youTubePlayerListener, iFramePlayerOptions)


        youTubePlayerView.addFullscreenListener(object : FullscreenListener {
            lateinit var fullView  : View
            override fun onEnterFullscreen(fullscreenView: View, exitFullscreen: () -> Unit) {
                findViewById<FrameLayout>(R.id.main).addView(fullscreenView)
                fullView = fullscreenView
            }

            override fun onExitFullscreen() {
                findViewById<FrameLayout>(R.id.main).removeView(fullView)
            }

        })
    }

}
package com.keysersoze.androidtvvideobrowser.ui.player

import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.android.exoplayer2.ExoPlayer
import com.google.android.exoplayer2.MediaItem
import com.google.android.exoplayer2.Player
import com.keysersoze.androidtvvideobrowser.databinding.FragmentPlayerBinding

class PlayerFragment : Fragment() {

    private var _binding: FragmentPlayerBinding? = null
    private val binding get() = _binding!!

    private var player: ExoPlayer? = null
    private var videoUrl: String? = null
    private var adapterIndex: Int = -1

    private var playbackPosition: Long = 0L
    private var playWhenReady = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        videoUrl = arguments?.getString(ARG_URL)
        adapterIndex = arguments?.getInt(ARG_INDEX) ?: -1
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPlayerBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onStart() {
        super.onStart()
        initializePlayer()
    }

    override fun onResume() {
        super.onResume()
        player?.play()
    }

    override fun onPause() {
        super.onPause()
        releasePlayer()
    }

    override fun onStop() {
        super.onStop()
        releasePlayer()
    }

    private fun initializePlayer() {
        if (player != null) return

        val context = requireContext()

        player = ExoPlayer.Builder(context).build().also { exoPlayer ->
            binding.playerView.player = exoPlayer

            val mediaItem = MediaItem.fromUri(Uri.parse(videoUrl))
            exoPlayer.setMediaItem(mediaItem)

            exoPlayer.seekTo(playbackPosition)
            exoPlayer.playWhenReady = true
            exoPlayer.prepare()

            exoPlayer.addListener(object : Player.Listener {
                override fun onPlaybackStateChanged(state: Int) {
                    if (state == Player.STATE_ENDED) {
                        parentFragmentManager.popBackStack()
                    }
                }
            })
        }
    }


    private fun releasePlayer() {
        player?.let { exoPlayer ->
            playbackPosition = exoPlayer.currentPosition
            playWhenReady = exoPlayer.playWhenReady
            exoPlayer.release()
        }
        player = null
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        private const val ARG_URL = "videoUrl"
        private const val ARG_INDEX = "adapterIndex"

        fun newInstance(url: String, index: Int): PlayerFragment {
            return PlayerFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_URL, url)
                    putInt(ARG_INDEX, index)
                }
            }
        }
    }
}

package com.keysersoze.androidtvvideobrowser.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.keysersoze.androidtvvideobrowser.data.VideoRepository
import com.keysersoze.androidtvvideobrowser.databinding.FragmentHomeBinding
import com.keysersoze.androidtvvideobrowser.ui.player.PlayerFragment

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private var lastFocusedIndex: Int? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val videos = VideoRepository.getVideos()

        val adapter = VideoAdapter(videos) { videoItem, index ->
            lastFocusedIndex = index
            openPlayer(videoItem.url, videoItem.title)
        }

        binding.recyclerView.apply {
            layoutManager = GridLayoutManager(requireContext(), 3)
            this.adapter = adapter
            setHasFixedSize(true)

            post { getChildAt(0)?.requestFocus() }
        }

        showLastPlayed()

    }

    override fun onResume() {
        super.onResume()

        lastFocusedIndex?.let { idx ->
            binding.recyclerView.post {
                binding.recyclerView.scrollToPosition(idx)

                binding.recyclerView.post {
                    binding.recyclerView.findViewHolderForAdapterPosition(idx)
                        ?.itemView
                        ?.requestFocus()
                }
            }
        }
    }

    private fun openPlayer(url: String, title: String) {
        parentFragmentManager.beginTransaction()
            .replace(
                com.keysersoze.androidtvvideobrowser.R.id.fragmentContainer,
                PlayerFragment.newInstance(url, title)
            )
            .addToBackStack(null)
            .commit()
    }

    private fun showLastPlayed() {
        val prefs = requireContext().getSharedPreferences("tv_prefs", 0)
        val lastTitle = prefs.getString("last_played_title", null)

        if (lastTitle != null) {
            binding.lastPlayedText.text = "Last Played: $lastTitle"
            binding.lastPlayedText.visibility = View.VISIBLE

            binding.lastPlayedText.animate()
                .alpha(1f)
                .setDuration(300)
                .start()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
package com.keysersoze.androidtvvideobrowser.data

import com.keysersoze.androidtvvideobrowser.domain.VideoItem

object VideoRepository {

    fun getVideos(): List<VideoItem> = listOf(

        VideoItem(
            "Big Buck Bunny",
            "https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4",
            "https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/images/BigBuckBunny.jpg"
        ),

        VideoItem(
            "Elephant Dream",
            "https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ElephantsDream.mp4",
            "https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/images/ElephantsDream.jpg"
        ),

        VideoItem(
            "For Bigger Blazes",
            "https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ForBiggerBlazes.mp4",
            "https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/images/ForBiggerBlazes.jpg"
        ),

        VideoItem(
            "For Bigger Escape",
            "https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ForBiggerEscapes.mp4",
            "https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/images/ForBiggerEscapes.jpg"
        ),

        VideoItem(
            "For Bigger Fun",
            "https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ForBiggerFun.mp4",
            "https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/images/ForBiggerFun.jpg"
        ),

        VideoItem(
            "For Bigger Joyrides",
            "https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ForBiggerJoyrides.mp4",
            "https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/images/ForBiggerJoyrides.jpg"
        ),

        VideoItem(
            "For Bigger Meltdowns",
            "https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ForBiggerMeltdowns.mp4",
            "https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/images/ForBiggerMeltdowns.jpg"
        ),

        VideoItem(
            "Sintel Trailer",
            "https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/Sintel.mp4",
            "https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/images/Sintel.jpg"
        ),

        VideoItem(
            "Tears of Steel",
            "https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/TearsOfSteel.mp4",
            "https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/images/TearsOfSteel.jpg"
        ),
    )
}

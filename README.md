# Android-TV-Video-Browser
A lightweight Android TV app for browsing and playing videos using ExoPlayer, optimized for D-pad navigation and smooth TV UI interactions.


📺 Android TV Video Browser

A lightweight Android TV application that allows users to browse a catalog of videos, navigate using the TV remote (D-pad), and play content using ExoPlayer.
Designed for smooth TV navigation, clean architecture, and reliable playback.

🎥 Demo Video

👉 Demo Video: 

👉 APK Download: 


🚀 Features

TV-friendly UI with D-pad support

Grid layout of video thumbnails + titles

Smooth focus animations (scale + glow)

ExoPlayer-based video playback

Back navigation returns gracefully to Home screen

Focus restored to previously selected item

“Last Played” memory stored locally

Works on real Android TV device + emulator

📦 Setup Instructions
1. Clone the Project
git clone https://github.com/keyserSoze98/Android-TV-Video-Browser

2. Open in Android Studio

Android Studio Ladybug or later

Open the folder as an Android project

Let Gradle sync automatically

3. Build & Run

Select an Android TV emulator (TV 1080p, API 34)
OR

Connect a physical Android TV device

Press Run ▶ in Android Studio.

📚 Dependencies Used
Library	Purpose
ExoPlayer	Video playback
AndroidX Leanback (optional UI helpers)	TV UI focus behavior
RecyclerView + GridLayoutManager	Video grid
Glide	Thumbnail loading
AndroidX Core KTX	Kotlin extensions
Versions (via libs.versions.toml)

Kotlin: 2.0.21

AndroidX Core KTX: 1.17.0

Leanback: 1.0.0

Glide: 4.11.0

ExoPlayer: 2.x

🖥️ Devices Used for Testing
1. Physical Device

SkyworthDigital 4K Android TV Box

Android 12

API Level 31

4K resolution

2. Emulator

Android TV (1080p)

API Level 34

Default Google TV D-pad navigation

Both environments validated:

Playback

Navigation

UI focus

Backstack behavior

🧱 Architecture Choices
1. Simple MVVM-like structure (lightweight by design)

The assignment prioritizes clean code and TV navigation, so the architecture is intentionally minimal:

UI Layer (Fragments + RecyclerView)

Data Layer (VideoRepository supplying static video data)

Domain Model (VideoItem)

No DI frameworks (e.g., Hilt) were used because:

App is small

Single source of data

Keeping complexity low aligns with assignment requirements

2. ExoPlayer Lifecycle Handling

Player created in onStart()

Playback resumed in onResume()

Player safely released in onPause() + onStop()

This avoids leaks and ensures smooth TV background behavior.

3. TV-First UX

Focus restoration using stored adapter index

Glow effect + scale animation for focused items

Controller hidden by default for immersive playback

⚠️ Known Issues / Limitations

Video list is static (not fetched from a server).

Player does not auto-play the next video (kept simple intentionally).

Custom controller view is minimalistic; could be expanded with more actions.

Basic replay behavior — does not handle playlists or looping logic.

No dedicated DI/Clean Architecture modules (to keep scope in line with assignment).

📝 Summary

This project delivers:

Clean, readable Kotlin code

Fully functional Android TV browsing

Smooth ExoPlayer playback

Proper lifecycle + navigation

Solid D-pad UX

Professional, scalable structure (ready for future expansion)

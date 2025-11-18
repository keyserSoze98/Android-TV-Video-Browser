package com.keysersoze.androidtvvideobrowser.ui.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.keysersoze.androidtvvideobrowser.R
import com.keysersoze.androidtvvideobrowser.ui.home.HomeFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Load HomeFragment only once
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainer, HomeFragment())
                .commit()
        }
    }
}
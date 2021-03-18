package com.a.randomsquare.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.a.randomsquare.R
import dagger.android.support.DaggerAppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
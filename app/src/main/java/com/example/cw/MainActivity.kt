package com.example.cw

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun openAboutScreen(view: View) {
        val intent = Intent(this, AboutActivity::class.java)
        startActivity(intent)
    }
    fun openNewGameScreen(view: View) {
        val intent = Intent(this, Rules::class.java)
        startActivity(intent)
    }
}



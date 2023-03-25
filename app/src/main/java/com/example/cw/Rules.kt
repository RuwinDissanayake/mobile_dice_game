package com.example.cw

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity

class Rules : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.rules)
    }
    fun openNewGameScreen(view: View) {
        val intent = Intent(this, NewGameActivity::class.java)
        startActivity(intent)
    }

}

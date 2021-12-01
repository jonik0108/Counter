package com.abbasov.counter

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()
        next.setOnClickListener {
            val korobka=edit1.text.toString().trim()
            val intent = Intent(this, Count::class.java)
            intent.putExtra("en", "$korobka") //second param is Serializable
            startActivity(intent)
            finish()


        }

    }
}
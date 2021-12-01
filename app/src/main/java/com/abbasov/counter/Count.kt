package com.abbasov.counter

import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_count.*
import java.text.SimpleDateFormat
import java.util.*

class Count : AppCompatActivity() {
    private lateinit var mHandler: Handler
    var runnable: Runnable? = null
    var count1=0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_count)
        val intent = intent
        var fName = intent.getStringExtra("en")
        if (fName != null) {
            count1= fName.toIntOrNull()!!
        }



        mHandler = Handler()
        runnable = Runnable {
            //your code
            if (isOnline(this)==true){
                count1 -= 100
                count.text=count1.toString()
                Toast.makeText(this, "go", Toast.LENGTH_SHORT).show()
            }
            if(count1<=0){
                startActivity(Intent(this,MainActivity::class.java))
                finish()
            }else{
                mHandler.postDelayed(runnable!!, 1000)

            }
            //finish your code
        }
        mHandler.postDelayed(runnable!!, 1000)

    }
    fun isOnline(context: Context): Boolean {
        val connectivityManager =
            context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        if (connectivityManager != null) {
            val capabilities =
                connectivityManager.getNetworkCapabilities(connectivityManager.activeNetwork)
            if (capabilities != null) {
                if (capabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR)) {
                    return true
                } else if (capabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI)) {
                    return true
                } else if (capabilities.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET)) {
                    return true
                }
            }
        }
        return false
    }
}
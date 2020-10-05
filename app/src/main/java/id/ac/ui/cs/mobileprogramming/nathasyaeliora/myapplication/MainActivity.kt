package id.ac.ui.cs.mobileprogramming.nathasyaeliora.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.Toast
import kotlin.system.exitProcess

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var stoptime:Long = 0

    }
    override fun onBackPressed() {
        val text = "Press exit button to exit app"
        val duration = Toast.LENGTH_SHORT
        Toast.makeText(applicationContext, text, duration).show()
    }

    fun exit_app(view: View) {
        exitProcess(0)
    }


}
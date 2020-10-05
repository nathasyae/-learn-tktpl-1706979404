package id.ac.ui.cs.mobileprogramming.nathasyaeliora.myapplication

import android.app.ActivityManager
import android.os.AsyncTask
import android.os.AsyncTask.execute
import android.os.Bundle
import android.os.SystemClock
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.Chronometer
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.lang.Thread.sleep
import kotlin.system.exitProcess

class MainActivity: AppCompatActivity() {
    val chronometer:Chronometer by lazy { findViewById<Chronometer>(R.id.chronometer) }
    val start_button:Button by lazy { findViewById<Button>(R.id.startButton) }
    val pause_button:Button by lazy { findViewById<Button>(R.id.pauseButton) }
    val reset_button:Button by lazy { findViewById<Button>(R.id.resetButton) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        pause_button.visibility = View.GONE

        var stoptime:Long = 0


        Thread(Runnable {
//      checkIfRunning()
            this.runOnUiThread() {
                start_button.setOnClickListener {
                    chronometer.base = SystemClock.elapsedRealtime() + stoptime
                    chronometer.start()

                    start_button.visibility = View.GONE
                    pause_button.visibility = View.VISIBLE
                }

                pause_button.setOnClickListener() {
                    stoptime = chronometer.base - SystemClock.elapsedRealtime()
                    chronometer.stop()

                    pause_button.visibility = View.GONE
                    start_button.visibility = View.VISIBLE
                }

                reset_button.setOnClickListener() {
                    chronometer.base = SystemClock.elapsedRealtime()
                    stoptime = 0
                    chronometer.stop()

                    pause_button.visibility = View.GONE
                    start_button.visibility = View.VISIBLE
                }
            }
        }).start()
}

    override fun onPause() {
        super.onPause()
        Log.i("TAG", "on pause")
    }

    fun checkIfRunning(){
        for (i in 0..100) {
            sleep(100)
            Log.i("TAG", "running")
        }
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
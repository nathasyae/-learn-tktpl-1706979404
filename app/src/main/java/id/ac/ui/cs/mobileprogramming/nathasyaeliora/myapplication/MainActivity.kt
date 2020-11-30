package id.ac.ui.cs.mobileprogramming.nathasyaeliora.myapplication

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.net.wifi.ScanResult
import android.net.wifi.WifiManager
import android.os.Bundle
import android.util.Log
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.row.*


class MainActivity : AppCompatActivity() {

    lateinit var adapter: ArrayAdapter<String>
    lateinit var wifiManager: WifiManager
    lateinit var results: List<ScanResult>
    var arrayStringResult:ArrayList<String> = arrayListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        Log.i("ngetest", "oncreate")
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        scan_button.setOnClickListener{
            startScanning()
        }

        wifiManager = applicationContext.getSystemService(Context.WIFI_SERVICE) as WifiManager

        if (!wifiManager.isWifiEnabled) {
            Toast.makeText(this, "Wifi is disabled, turn it on", Toast.LENGTH_LONG).show()
            wifiManager.setWifiEnabled(true)
        }

        adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, arrayStringResult)
        list_view.adapter = adapter


    }

    private fun startScanning(){
        Log.i("ngetest", "masuk startscanning")
        val wifiScanReceiver = object : BroadcastReceiver() {

            override fun onReceive(context: Context, intent: Intent) {
                val success = intent.getBooleanExtra(WifiManager.EXTRA_RESULTS_UPDATED, false)
                if (success) {
                    scanSuccess()
                } else {
                    scanFailure()
                }
            }
        }

        val intentFilter = IntentFilter()
        intentFilter.addAction(WifiManager.SCAN_RESULTS_AVAILABLE_ACTION)
        applicationContext.registerReceiver(wifiScanReceiver, intentFilter)

        val success = wifiManager.startScan()
        if (!success) {
            // scan failure handling
            scanFailure()
        }
    }

    private fun scanSuccess() {
        val results = wifiManager.scanResults
        results.forEach {
            Log.i("ssid", it.toString())
            this.arrayStringResult.add(it.SSID)
            adapter.notifyDataSetChanged()
        }
        Log.i("ngetest", arrayStringResult.toString())
    }

    private fun scanFailure() {
        // handle failure: new scan did NOT succeed
        // consider using old scan results: these are the OLD results!
        val results = wifiManager.scanResults
    }
}
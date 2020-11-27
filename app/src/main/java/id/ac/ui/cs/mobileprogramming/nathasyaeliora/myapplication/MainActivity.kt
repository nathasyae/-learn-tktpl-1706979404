package id.ac.ui.cs.mobileprogramming.nathasyaeliora.myapplication

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.net.wifi.ScanResult
import android.net.wifi.WifiManager
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.row.*


class MainActivity : AppCompatActivity() {

    val listView = findViewById<ListView>(R.id.list_view)
    val scanBtn = findViewById<Button>(R.id.scan_button)
    val size: Int = 0
    val adapter: Adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, arrayList)
    lateinit var wifiManager: WifiManager
    lateinit var results: List<ScanResult>
    lateinit var arrayList: ArrayList<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        wifiManager = applicationContext.getSystemService(WIFI_SERVICE) as WifiManager

        if (!wifiManager.isWifiEnabled) {
            Toast.makeText(this, "Wifi is disabled, turn it on", Toast.LENGTH_LONG).show()
            wifiManager.isWifiEnabled = true
        }

        listView.setAdapter(adapter)
        startScanning()
    }

    fun startScanning(){
        arrayList.clear()
        registerReceiver(wifiReceiver, IntentFilter(wifiManager.SCAN_RESULT_AVAILABLE_ACTION);
    }

    var wifiReceiver:BroadcastReceiver = object:BroadcastReceiver() {
       override fun onReceive(context:Context, intent:Intent) {
            results = wifiManager.getScanResults()
            unregisterReceiver(this)

            for (scanResult in results)
            {
                arrayList.add(scanResult.SSID)
                adapter.notifyDataSetChanged()
            }
        }
    }
}


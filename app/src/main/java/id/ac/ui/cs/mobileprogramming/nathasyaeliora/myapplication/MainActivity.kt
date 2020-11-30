package id.ac.ui.cs.mobileprogramming.nathasyaeliora.myapplication

import android.Manifest
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.content.pm.PackageManager.PERMISSION_GRANTED
import android.net.wifi.ScanResult
import android.net.wifi.WifiManager
import android.os.Bundle
import android.util.Log
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import id.ac.ui.cs.mobileprogramming.nathasyaeliora.myapplication.API.APIService
import id.ac.ui.cs.mobileprogramming.nathasyaeliora.myapplication.API.ApiUtils.aPIService
import id.ac.ui.cs.mobileprogramming.nathasyaeliora.myapplication.API.Post
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.row.*
import retrofit2.Call
import retrofit2.Response
import javax.security.auth.callback.Callback


class MainActivity : AppCompatActivity() {

    val callbackId = 37
    lateinit var adapter: ArrayAdapter<String>
    lateinit var wifiManager: WifiManager
    lateinit var results: List<ScanResult>
    lateinit var mAPIService: APIService
    var arrayStringResult:ArrayList<String> = arrayListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        Log.i("ngetest", "oncreate")
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        checkPermission(
            callbackId,
            Manifest.permission.ACCESS_FINE_LOCATION,
            Manifest.permission.ACCESS_COARSE_LOCATION,
            Manifest.permission.INTERNET
        )

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

        mAPIService = aPIService

        send_button.setOnClickListener {
            sendPost(arrayStringResult)
        }

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

    // API
    fun sendPost(wifi_list: ArrayList<String>?) {
        mAPIService.savePost(wifi_list)!!.enqueue(object : retrofit2.Callback<Post?> {
            override fun onResponse(call: Call<Post?>?, response: Response<Post?>) {
                if (response.isSuccessful()) {
                    showSuccessToast()
                    Log.i("POST", "post submitted to API.")
                }
            }

            override fun onFailure(call: Call<Post?>?, t: Throwable?) {
                Log.e("POST", "Unable to submit post to API.")
            }
        })
    }

    fun showSuccessToast() {
        Toast.makeText(this, "sent to requestbin", Toast.LENGTH_LONG).show()
    }

    private fun checkPermission(callbackId: Int, vararg permissionsId: String) {
        var permissions = true
        for (p in permissionsId) {
            permissions =
                permissions && ContextCompat.checkSelfPermission(this, p) == PERMISSION_GRANTED
        }
        if (!permissions) ActivityCompat.requestPermissions(this, permissionsId, callbackId)
    }

}
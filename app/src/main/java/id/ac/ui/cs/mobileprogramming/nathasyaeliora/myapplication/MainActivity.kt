package id.ac.ui.cs.mobileprogramming.nathasyaeliora.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        calc_btn.setOnClickListener() {
            val quantity = input_qt.text.toString().toInt()
            Log.i("CHECK-QTY", quantity.toString())
            val total_price_result = calculteTotalPrice(quantity)
            Log.i("CHECK-RESULT", total_price_result.toString())
            total_price.text = "Your total price is IDR " + total_price_result + "K"
        }

    }

    external fun calculteTotalPrice(qt: Int): Int

    companion object {
        init {
            System.loadLibrary("native-lib")
        }
    }
}
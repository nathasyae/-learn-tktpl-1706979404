package id.ac.ui.cs.mobileprogramming.nathasyaeliora.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val input_name = findViewById<EditText>(R.id.inputName)
        val display_text = findViewById<TextView>(R.id.display)
        val submit_button = findViewById<Button>(R.id.submitButton)

        submit_button.setOnClickListener{
            display_text.text = "Hello, " + input_name.text + "!"
        }
    }
}
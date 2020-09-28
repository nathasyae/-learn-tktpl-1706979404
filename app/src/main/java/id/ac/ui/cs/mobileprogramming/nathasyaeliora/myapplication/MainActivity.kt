package id.ac.ui.cs.mobileprogramming.nathasyaeliora.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    val input_name:EditText by lazy { findViewById<EditText>(R.id.inputName) }
    val display_text:TextView by lazy {findViewById<TextView>(R.id.display)}
    val submit_button:Button by lazy {findViewById<Button>(R.id.submitButton)}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        submit_button.setOnClickListener{
            if(validateInputName(input_name.text.toString())){
                display_text.text = "Hello, " + input_name.text.toString() + "!"
            }
        }
    }

    fun validateInputName(input_name: String): Boolean {
        return input_name.matches("^[a-zA-Z]*$".toRegex()) and (input_name.length>0)
    }

}
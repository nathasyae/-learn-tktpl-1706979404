package id.ac.ui.cs.mobileprogramming.nathasyaeliora.myapplication

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Switch
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI


class MainActivity : AppCompatActivity() {
    private var navController: NavController? = null
    private var sharedViewModel: SharedViewModel? = null
    val themeSwitch by lazy { findViewById<Switch>(R.id.themeSwitch) }



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        navController = Navigation.findNavController(this, R.id.nav_host_fragment)
        NavigationUI.setupActionBarWithNavController(this, navController!!)
        sharedViewModel = ViewModelProvider(this).get<SharedViewModel>(SharedViewModel::class.java)

        themeSwitch.setOnCheckedChangeListener{_,checkedId -> when (checkedId) {
            true -> AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
            false -> AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        }
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        navController?.navigateUp()
        return super.onSupportNavigateUp()
    }
}
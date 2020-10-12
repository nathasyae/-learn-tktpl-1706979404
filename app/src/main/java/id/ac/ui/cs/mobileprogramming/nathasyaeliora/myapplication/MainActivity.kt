package id.ac.ui.cs.mobileprogramming.nathasyaeliora.myapplication

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI


class MainActivity : AppCompatActivity() {
    private var navController: NavController? = null
    private var sharedViewModel: SharedViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(id.ac.ui.cs.mobileprogramming.nathasyaeliora.myapplication.R.layout.activity_main)
        navController = Navigation.findNavController(this, id.ac.ui.cs.mobileprogramming.nathasyaeliora.myapplication.R.id.nav_host_fragment)
        NavigationUI.setupActionBarWithNavController(this, navController!!)
        sharedViewModel = ViewModelProvider(this).get<SharedViewModel>(SharedViewModel::class.java)
    }

    override fun onSupportNavigateUp(): Boolean {
        navController?.navigateUp()
        return super.onSupportNavigateUp()
    }

//    override fun onCreateOptionsMenu(menu: Menu): Boolean {
//        menuInflater.inflate(R.menu.main_menu, menu)
//        return true
//    }

//    override fun onOptionsItemSelected(item: MenuItem): Boolean {
//        if (item.itemId == id.ac.ui.cs.mobileprogramming.nathasyaeliora.myapplication.R.id.action_add_item) {
////            Toast.makeText(this, "Add Item", Toast.LENGTH_SHORT).show();
////            addMovie()
//            return true
//        }
//        return super.onOptionsItemSelected(item)
//    }

//    private fun addMovie() {
//        val movie = Movie("Avenger's", Random().nextDouble())
//        sharedViewModel.addMovie(movie)
//    }
}
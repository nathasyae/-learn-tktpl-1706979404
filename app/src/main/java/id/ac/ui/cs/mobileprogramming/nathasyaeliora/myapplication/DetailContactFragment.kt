package id.ac.ui.cs.mobileprogramming.nathasyaeliora.myapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.annotation.Nullable
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.Navigation
import id.ac.ui.cs.mobileprogramming.nathasyaeliora.myapplication.model.Contact
import java.lang.String
import id.ac.ui.cs.mobileprogramming.nathasyaeliora.myapplication.R


class DetailFragment : Fragment() {
    private var nameTextView: TextView? = null
    private var telephoneTextView: TextView? = null
    private var navController: NavController? = null
    private var sharedViewModel: SharedViewModel? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail, container, false)
    }

    override fun onViewCreated(view: View, @Nullable savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        nameTextView = view.findViewById(R.id.nameTextView)
        telephoneTextView = view.findViewById(R.id.telephoneTextView)
        navController = Navigation.findNavController(view)
        sharedViewModel = ViewModelProvider(requireActivity()).get<SharedViewModel>(SharedViewModel::class.java)
        sharedViewModel!!.contact.observe(getViewLifecycleOwner(), object : Observer<Contact?> {
            override fun onChanged(contact: Contact?) {
                if (contact != null) {
                    updateUI(contact)
                }
            }
        })
    }

    private fun updateUI(contact: Contact) {
        nameTextView?.setText(contact.name)
        telephoneTextView?.setText(String.valueOf(contact.telephone))
    }
}
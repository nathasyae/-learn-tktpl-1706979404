package id.ac.ui.cs.mobileprogramming.nathasyaeliora.myapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView
import id.ac.ui.cs.mobileprogramming.nathasyaeliora.myapplication.model.Contact
import java.util.*


/**
 * A simple [Fragment] subclass.
 */
class MasterFragment : Fragment(), ContactAdapter.OnItemCLickListener {
    private var recyclerView: RecyclerView? = null
    private var contactAdapter: ContactAdapter? = null
    private var navController: NavController? = null
    private var sharedViewModel: SharedViewModel? = null
    private val contactList: MutableList<Contact> = ArrayList()
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_master, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)
        recyclerView = view.findViewById(R.id.recyclerView)
        contactAdapter = ContactAdapter(contactList, this)
        recyclerView.setAdapter(contactAdapter)
        recyclerView.addItemDecoration(DividerItemDecoration(requireContext(), DividerItemDecoration.VERTICAL))
        sharedViewModel = ViewModelProvider(requireActivity()).get<SharedViewModel>(SharedViewModel::class.java)
        sharedViewModel.contactList.observe(viewLifecycleOwner, Observer<List<Contact>?> { contacts ->
            contactList.clear()
            contactList.addAll(contacts!!)
            contactAdapter!!.notifyDataSetChanged()
        })
    }

    override fun onItemClick(position: Int) {
//        Toast.makeText(requireContext(), String.valueOf(position), Toast.LENGTH_SHORT).show();
        sharedViewModel?.setContact(position)
        navController?.navigate(R.id.action_masterFragment_to_detailFragment)
    }
}
}
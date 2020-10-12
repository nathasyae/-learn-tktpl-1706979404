package id.ac.ui.cs.mobileprogramming.nathasyaeliora.myapplication

import android.R
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import id.ac.ui.cs.mobileprogramming.nathasyaeliora.myapplication.model.Contact
//import id.ac.ui.cs.mobileprogramming.nathasyaeliora.myapplication.res
import java.lang.String


class ContactAdapter(var contactList: List<Contact>, var onItemCLickListener: OnItemCLickListener) : RecyclerView.Adapter<ContactAdapter.ContactViewHolder?>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactViewHolder {
        return ContactViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.recycler_row, parent, false))
    }

    override fun onBindViewHolder(holder: ContactViewHolder, position: Int) {
        holder.bind(contactList[position])
    }

    override fun getItemCount(): Int {
        return contactList.size
    }

    inner class ContactViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val nameTextView: TextView
        private val telephoneTextView: TextView
        fun bind(contact: Contact) {
            nameTextView.setText(contact.name)
            telephoneTextView.setText(String.valueOf(contact.telephone))
        }

        init {
            nameTextView = itemView.findViewById(id.ac.ui.cs.mobileprogramming.nathasyaeliora.myapplication.R.id.nameTextView)
            telephoneTextView = itemView.findViewById(id.ac.ui.cs.mobileprogramming.nathasyaeliora.myapplication.R.id.telephoneTextView)
            itemView.setOnClickListener { onItemCLickListener.onItemClick(getAdapterPosition()) }
        }
    }

    interface OnItemCLickListener {
        fun onItemClick(position: Int)
    }
}
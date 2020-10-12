package id.ac.ui.cs.mobileprogramming.nathasyaeliora.myapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
//import androidx.lifecycle.extensions.R
import id.ac.ui.cs.mobileprogramming.nathasyaeliora.myapplication.Communicator
import id.ac.ui.cs.mobileprogramming.nathasyaeliora.myapplication.ReceiveFragment

class ReceiveFragment: Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val myView=LayoutInflater.from(container!!.context).inflate(R.layout.fragment2,container,false)
        return myView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val btn=view.findViewById<View>(R.id.btnBack) as Button
        val txt=view.findViewById<View>(R.id.txreceiver) as TextView

        val model= ViewModelProviders.of(activity!!).get(Communicator::class.java)

        model.message.observe(this, object : Observer<Any> {
            override fun onChanged(o: Any?) {
                txt.text = o!!.toString()
            }
        })
        btn.setOnClickListener { view ->
            //write some code here
        }
    }

}
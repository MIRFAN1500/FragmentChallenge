package com.binar.singgleactivity

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction


class ThirdFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_third, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val nama = arguments?.getString("nama")
        val dataClass = arguments?.getParcelable<Person>("key_person")

        val namaTextView = view.findViewById<TextView>(R.id.nama_text_view)
        val emailTextView = view.findViewById<TextView>(R.id.email_text_view)
        val umurTextView = view.findViewById<TextView>(R.id.umur_text_view)
        val alamatTextView = view.findViewById<TextView>(R.id.alamat_text_view)

        val navigateToFourthFragment = view.findViewById<Button>(R.id.navigate_to_fourth_fragment_button)
        namaTextView.text = nama

        dataClass?.let {
            val umur = if (it.umur.toInt() % 2 == 0) "Genap" else "Ganjil"
            namaTextView.text = it.nama
            emailTextView.visibility = View.VISIBLE
            umurTextView.visibility = View.VISIBLE
            alamatTextView.visibility = View.VISIBLE
            emailTextView.text = it.email
            umurTextView.text = "${it.umur}, ${umur}"
            alamatTextView.text = it.alamat
        }


        navigateToFourthFragment.setOnClickListener {
            val fragmentManager: FragmentManager = parentFragmentManager
            val fragmentTransaction: FragmentTransaction = fragmentManager.beginTransaction()
            val fourFragment = FourFragment()

            val bundle = Bundle()
            bundle.putString("nama",nama)
            fourFragment.arguments = bundle

            fragmentTransaction.replace(R.id.frame_layout_container, fourFragment, FourFragment::class.java.simpleName)
            fragmentTransaction.addToBackStack(null)
            fragmentTransaction.commit()


        }
    }
}
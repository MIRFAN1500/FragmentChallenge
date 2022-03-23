package com.binar.singgleactivity

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction


class SecondFragment : Fragment() {
    private lateinit var navigateToThirdFragment: Button
    private lateinit var nama: EditText



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_second, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navigateToThirdFragment = view.findViewById(R.id.navigate_to_third_fragment_button)
        nama= view.findViewById(R.id.nama)




        navigateToThirdFragment.setOnClickListener {
            val fragmentManager: FragmentManager = parentFragmentManager
            val fragmentTransaction: FragmentTransaction = fragmentManager.beginTransaction()
            val thirdFragment = ThirdFragment()

            val inputNama = nama.text.toString()
//            val inputEmail = email.text.toString()
//            val inputUmur = umur.text.toString()

            val bundle = Bundle()
            bundle.putString("nama", inputNama)
//            bundle.putString("email", inputEmail)
//            bundle.putString("umur", inputUmur)
            thirdFragment.arguments = bundle


            fragmentTransaction.replace(R.id.frame_layout_container, thirdFragment, ThirdFragment::class.java.simpleName)
            fragmentTransaction.addToBackStack(null)
            fragmentTransaction.commit()
        }
    }

}
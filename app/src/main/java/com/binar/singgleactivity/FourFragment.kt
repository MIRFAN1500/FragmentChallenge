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


class FourFragment : Fragment() {
    private lateinit var navigateBackToThirdFragment: Button
    private lateinit var email: EditText
    private lateinit var umur: EditText
    private lateinit var alamat: EditText


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_four, container, false)

    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navigateBackToThirdFragment = view.findViewById(R.id.navigate_back_to_third_fragment_button)
        email = view.findViewById(R.id.email)
        umur = view.findViewById(R.id.umur)
        alamat = view.findViewById(R.id.alamat)

        val nama = arguments?.getString("nama")
        navigateBackToThirdFragment.setOnClickListener {
            val fragmentManager: FragmentManager = parentFragmentManager
            val fragmentTransaction: FragmentTransaction = fragmentManager.beginTransaction()
            val thirdFragment = ThirdFragment()

            val inputEmail = email.text.toString()
            val inputUmur = umur.text.toString()
            val inputAlamat = alamat.text.toString()
            nama?.let {
                val dataClassPerson = Person(
                    it , inputEmail, inputUmur, inputAlamat
                )
                val bundle = Bundle()
                bundle.putParcelable("key_person",dataClassPerson)
                thirdFragment.arguments = bundle


                fragmentTransaction.replace(R.id.frame_layout_container, thirdFragment, ThirdFragment::class.java.simpleName)
                fragmentTransaction.addToBackStack(null)
                fragmentTransaction.commit()
            }

        }
    }

}

package com.binar.singgleactivity

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER


/**
 * A simple [Fragment] subclass.
 * Use the [FirstFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class FirstFragment : Fragment() {
    //private lateinit var navigateToSecodFragmentButton: Button
    private lateinit var navigateToSecondFragmentButton: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navigateToSecondFragmentButton = view.findViewById(R.id.navigate_to_second_fragment_button)

        navigateToSecondFragmentButton.setOnClickListener {
            val fragmentManager: FragmentManager = parentFragmentManager
            val fragmentTransaction: FragmentTransaction = fragmentManager.beginTransaction()
            val secondFragment = SecondFragment()
            fragmentTransaction.replace(
                R.id.frame_layout_container,
                secondFragment,
                SecondFragment::class.java.simpleName
            )
            fragmentTransaction.commit()
        }
//Nampilin Toast
//        navigateToSecodFragmentButton = view.findViewById(R.id.navigate_to_second_fragment_button)
//        navigateToSecodFragmentButton.setOnClickListener {
//            Toast.makeText(requireActivity(), "Hai Irfan", Toast.LENGTH_SHORT).show()
//        }
//    }

    }
}
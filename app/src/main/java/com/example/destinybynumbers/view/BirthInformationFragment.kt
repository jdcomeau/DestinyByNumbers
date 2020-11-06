package com.example.destinybynumbers.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.destinybynumbers.R

class BirthInformationFragment: Fragment() {
    companion object{
        val EXTRA_ITEM = "BirthInformationFragment"
        fun newInstance(item: BirthInformationFragment): BirthInformationFragment{
            val fragment = BirthInformationFragment()
            val bundle = Bundle()
//            bundle.putParcelable(EXTRA_ITEM, item)
            fragment.arguments = bundle
            return fragment
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        val view = inflater.inflate(
            R.layout.birth_info_fragment,
            container, true)
        return view
    }
}
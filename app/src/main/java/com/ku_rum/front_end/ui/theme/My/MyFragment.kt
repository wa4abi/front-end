package com.ku_rum.front_end.ui.theme.My

import com.ku_rum.front_end.BaseFragment
import com.ku_rum.front_end.R
import com.ku_rum.front_end.databinding.FragmentMyBinding

class MyFragment : BaseFragment<FragmentMyBinding>(FragmentMyBinding::inflate){
    override fun initAfterBinding() {
        parentFragmentManager.beginTransaction()
            .replace(R.id.fcv_my, MyMainFragment())
            .addToBackStack(null)
            .commit()
    }
}
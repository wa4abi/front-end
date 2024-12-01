package com.example.ku_rum.MyPage

import com.example.ku_rum.MyPage.adapter.MyInformRVAdapter
import com.example.ku_rum.MyPage.data.InformData
import com.ku_rum.front_end.BaseFragment
import com.ku_rum.front_end.R
import com.ku_rum.front_end.databinding.FragmentMyInformBinding
import com.ku_rum.front_end.ui.theme.My.MyMainFragment

class MyInformFragment : BaseFragment<FragmentMyInformBinding>(FragmentMyInformBinding::inflate) {

    private lateinit var myInformRVAdapter: MyInformRVAdapter
    private var informList: List<InformData> = listOf()

    override fun initAfterBinding() {

        myInformRVAdapter = MyInformRVAdapter(requireActivity(), informList)
        binding.ivMyBack.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.fcv_my, MyMainFragment())
                .addToBackStack(null)
                .commit()
        }
    }
}
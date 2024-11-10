package com.example.ku_rum.MyPage

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.ku_rum.MyPage.adapter.MyInformRVAdapter
import com.example.ku_rum.MyPage.data.InformData
import com.ku_rum.front_end.BaseFragment
import com.ku_rum.front_end.databinding.FragmentMyInformBinding


class MyInformFragment : BaseFragment<FragmentMyInformBinding>(FragmentMyInformBinding::inflate) {

    private lateinit var myInformRVAdapter: MyInformRVAdapter
    private var informList: List<InformData> = listOf()

    override fun initAfterBinding() {
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        var binding = FragmentMyInformBinding.inflate(layoutInflater)
        myInformRVAdapter = MyInformRVAdapter(requireActivity(), informList)

        // 알림 목록 불러오기

        return binding.root
    }

}
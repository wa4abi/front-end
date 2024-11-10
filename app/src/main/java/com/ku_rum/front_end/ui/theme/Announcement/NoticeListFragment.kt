package com.example.ku_rum.Notice

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.ku_rum.Notice.adapter.NoticeRVAdapter
import com.ku_rum.front_end.BaseFragment
import com.ku_rum.front_end.databinding.FragmentNoticeListBinding
import com.ku_rum.front_end.ui.theme.Announcement.data.NoticeData


class NoticeListFragment : BaseFragment<FragmentNoticeListBinding>(FragmentNoticeListBinding::inflate) {

    private lateinit var noticeRVAdapter: NoticeRVAdapter
    private val noticeList: ArrayList<NoticeData> = arrayListOf()

    override fun initAfterBinding() {
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var binding = FragmentNoticeListBinding.inflate(layoutInflater)

        noticeRVAdapter = NoticeRVAdapter(requireActivity(), noticeList)
        binding.rvNoticeList.adapter = noticeRVAdapter

        return binding.root
    }

}
package com.ku_rum.front_end.ui.theme.Announcement

import android.os.Bundle
import android.util.Log
import com.example.ku_rum.Notice.adapter.NoticeVPAdapter
import com.google.android.material.tabs.TabLayoutMediator
import com.kakao.sdk.common.util.Utility
import com.ku_rum.front_end.BaseFragment
import com.ku_rum.front_end.databinding.FragmentAnnouncementBinding
import com.ku_rum.front_end.ui.theme.Announcement.data.NoticeData

class AnnouncementFragment : BaseFragment<FragmentAnnouncementBinding>(FragmentAnnouncementBinding::inflate){

    private lateinit var noticeVPAdapter: NoticeVPAdapter
    private val tabItems = arrayOf("학사", "장학", "취창업", "국제", "사람인", "원티드")
    private val noticeList: ArrayList<NoticeData> = arrayListOf()

    override fun initAfterBinding() {
        var keyHash = Utility.getKeyHash(requireContext())

        Log.d("key", keyHash)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        var binding = FragmentAnnouncementBinding.inflate(layoutInflater)

        TabLayoutMediator(binding.tlNotice, binding.vpNoticeList){tab, position ->
            tab.text = tabItems[position]
        }.attach()

        noticeVPAdapter = NoticeVPAdapter(requireActivity())
        binding.vpNoticeList.adapter = noticeVPAdapter

        binding.ivNoticeSearch.setOnClickListener{

        }

    }

}
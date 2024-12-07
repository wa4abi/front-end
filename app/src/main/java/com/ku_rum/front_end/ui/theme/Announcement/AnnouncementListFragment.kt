package com.ku_rum.front_end.ui.theme.Announcement

import com.example.ku_rum.Notice.adapter.NoticeVPAdapter
import com.google.android.material.tabs.TabLayoutMediator
import com.ku_rum.front_end.BaseFragment
import com.ku_rum.front_end.databinding.FragmentAnnouncementListBinding
import com.ku_rum.front_end.ui.theme.Announcement.data.NoticeData


class AnnouncementListFragment : BaseFragment<FragmentAnnouncementListBinding>(FragmentAnnouncementListBinding::inflate) {
    private lateinit var noticeVPAdapter: NoticeVPAdapter
    private val tabItems = arrayOf("학사", "장학", "취창업", "국제", "사람인", "원티드")
    private val noticeList: ArrayList<NoticeData> = arrayListOf()

    override fun initAfterBinding(){
        noticeVPAdapter = NoticeVPAdapter(requireActivity())
        binding.vpNoticeList.adapter = noticeVPAdapter

        TabLayoutMediator(binding.tlNotice, binding.vpNoticeList){tab, position ->
            tab.text = tabItems[position]
        }.attach()
    }
}
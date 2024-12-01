package com.ku_rum.front_end.ui.theme.Announcement.adapter

import android.content.Context
import android.view.inputmethod.EditorInfo
import android.view.inputmethod.InputMethodManager
import com.example.ku_rum.Notice.adapter.NoticeRVAdapter
import com.ku_rum.front_end.BaseFragment
import com.ku_rum.front_end.databinding.FragmentAnnouncementSearchBinding
import com.ku_rum.front_end.ui.theme.Announcement.data.NoticeData


class AnnouncementSearchFragment : BaseFragment<FragmentAnnouncementSearchBinding>(FragmentAnnouncementSearchBinding::inflate) {
    private lateinit var noticeRVAdapter: NoticeRVAdapter
    private var noticeList: ArrayList<NoticeData> = arrayListOf()
    private var searchedList: ArrayList<NoticeData> = arrayListOf()

    override fun initAfterBinding() {
        binding.etNoticeSearch.setOnEditorActionListener{textView, i, keyEvent ->
            if(i == EditorInfo.IME_ACTION_SEARCH){
                val imm = requireContext().getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
                imm.hideSoftInputFromWindow(binding.etNoticeSearch.windowToken, 0)
                binding.etNoticeSearch.clearFocus()

                val query = binding.etNoticeSearch.toString()
                searchNotice(query)

                true
            }
            else
            {
                false
            }
        }

        noticeRVAdapter = NoticeRVAdapter(requireActivity(), searchedList)
        binding.rvNoticeSearched.adapter = noticeRVAdapter
    }

    private fun searchNotice(query: String){
        searchedList.clear()
        if(query.isNotEmpty()) {
            val result = noticeList.filter { it.title.contains(query) }
            searchedList.addAll(result)
        } else {
            searchedList.addAll(noticeList)
        }
        noticeRVAdapter.notifyDataSetChanged()
    }

}
package com.example.ku_rum.MyPage

import android.content.Context
import android.view.inputmethod.EditorInfo
import android.view.inputmethod.InputMethodManager
import com.example.ku_rum.MyPage.adapter.MoreFriendRVAdapter
import com.example.ku_rum.MyPage.data.FriendData
import com.ku_rum.front_end.BaseFragment
import com.ku_rum.front_end.R
import com.ku_rum.front_end.databinding.FragmentMyMoreFriendBinding
import com.ku_rum.front_end.ui.theme.My.MyMainFragment


class MyMoreFriendFragment : BaseFragment<FragmentMyMoreFriendBinding>(FragmentMyMoreFriendBinding::inflate) {

    private lateinit var moreFriendRVAdapter: MoreFriendRVAdapter
    private var userList: List<FriendData> = listOf(
        FriendData(0, "김쿠룸")
    )

    override fun initAfterBinding() {
        moreFriendRVAdapter = MoreFriendRVAdapter(requireActivity(), userList)

        binding.ivMyBack.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.fcv_my, MyMainFragment())
                .addToBackStack(null)
                .commit()
        }

        val et = binding.etMoreFriend
        val imm = requireContext().getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager

        et.setOnFocusChangeListener { view, hasFocus ->
            if(hasFocus) {
                imm.showSoftInput(view, InputMethodManager.SHOW_IMPLICIT)
            } else {
                imm.hideSoftInputFromWindow(view.windowToken, 0)
            }
        }

        et.setOnEditorActionListener { textView, i, keyEvent ->
            if (i == EditorInfo.IME_ACTION_SEARCH) {

                val searchQuery = et.text.toString()

                val filteredFriend = userList.filter { friend ->
                    friend.name.contains(searchQuery, false)
                }
                moreFriendRVAdapter.update(filteredFriend)

                true
            } else {
                false
            }
        }
    }

}
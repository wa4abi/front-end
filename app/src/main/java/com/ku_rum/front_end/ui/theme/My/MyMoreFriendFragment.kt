package com.example.ku_rum.MyPage

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import android.view.inputmethod.InputMethodManager
import com.example.ku_rum.MyPage.adapter.MoreFriendRVAdapter
import com.example.ku_rum.MyPage.data.FriendData
import com.ku_rum.front_end.BaseFragment
import com.ku_rum.front_end.databinding.FragmentMyMoreFriendBinding


class MyMoreFriendFragment : BaseFragment<FragmentMyMoreFriendBinding>(FragmentMyMoreFriendBinding::inflate) {

    private lateinit var moreFriendRVAdapter: MoreFriendRVAdapter
    private var friendList: List<FriendData> = listOf()

    override fun initAfterBinding() {
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        var binding = FragmentMyMoreFriendBinding.inflate(layoutInflater)
        moreFriendRVAdapter = MoreFriendRVAdapter(requireActivity(), friendList)

        binding.etMoreFriend.setOnEditorActionListener { textView, i, keyEvent ->
            if (i == EditorInfo.IME_ACTION_SEARCH) {
                val imm =
                    requireContext().getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
                imm.hideSoftInputFromWindow(binding.etMoreFriend.windowToken, 0)
                binding.etMoreFriend.clearFocus()

                val searchQuery = binding.etMoreFriend.text.toString()

                val filteredFriend = friendList.filter { friend ->
                    friend.name.contains(searchQuery, false)
                }
                moreFriendRVAdapter.update(filteredFriend)

                true
            } else {
                false
            }
        }

        return binding.root
    }
}
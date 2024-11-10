package com.example.ku_rum.MyPage

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import android.view.inputmethod.InputMethodManager
import com.example.ku_rum.Dialog.DialogConfirmFragment
import com.example.ku_rum.MyPage.adapter.MyFriendRVAdapter
import com.example.ku_rum.MyPage.data.FriendData
import com.ku_rum.front_end.BaseFragment
import com.ku_rum.front_end.databinding.FragmentMyFriendBinding


class MyFriendFragment : BaseFragment<FragmentMyFriendBinding>(FragmentMyFriendBinding::inflate) {

    private lateinit var myFriendRVAdapter: MyFriendRVAdapter
    private var myFriendList: List<FriendData> = listOf()

    override fun initAfterBinding() {
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var binding = FragmentMyFriendBinding.inflate(layoutInflater)
        myFriendRVAdapter = MyFriendRVAdapter(requireActivity(), myFriendList)

        // 친구 목록 가져와야함

        binding.etMyFriend.setOnEditorActionListener{ textView, i, keyEvent ->
            if(i == EditorInfo.IME_ACTION_SEARCH){
                val imm = requireContext().getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
                imm.hideSoftInputFromWindow(binding.etMyFriend.windowToken, 0)
                binding.etMyFriend.clearFocus()

                val searchQuery = binding.etMyFriend.text.toString()

                val filteredFriend = myFriendList.filter { friend ->
                    friend.name.contains(searchQuery, false)
                }
                myFriendRVAdapter.update(filteredFriend)

                true
            }
            else {
                false
            }
        }

        return binding.root
    }

    private fun showDialog() {
        val message = "프래그먼트에 따라 다르게 설정된 메시지입니다."
        val dialog = DialogConfirmFragment.newInstance(message)
        dialog.show(parentFragmentManager, "MyDialogFragment")
    }

}
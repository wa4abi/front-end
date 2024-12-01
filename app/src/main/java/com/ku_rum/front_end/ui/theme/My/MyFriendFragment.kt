package com.example.ku_rum.MyPage

import android.content.Context
import android.view.inputmethod.EditorInfo
import android.view.inputmethod.InputMethodManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ku_rum.Dialog.DialogConfirmFragment
import com.example.ku_rum.MyPage.adapter.MyFriendRVAdapter
import com.example.ku_rum.MyPage.data.FriendData
import com.ku_rum.front_end.BaseFragment
import com.ku_rum.front_end.ui.theme.My.MyMainFragment
import com.ku_rum.front_end.R
import com.ku_rum.front_end.databinding.FragmentMyFriendBinding


class MyFriendFragment : BaseFragment<FragmentMyFriendBinding>(FragmentMyFriendBinding::inflate) {

    private lateinit var myFriendRVAdapter: MyFriendRVAdapter
    private var myFriendList: List<FriendData> = listOf(
        FriendData(0,"Friend"),
        FriendData(1,"김쿠룸"),
        FriendData(2,"김쿠룸"),
        FriendData(3,"김쿠룸"),
        FriendData(4,"김쿠룸"),
        FriendData(5,"김쿠룸")
    )

    override fun initAfterBinding() {
        myFriendRVAdapter = MyFriendRVAdapter(requireActivity(), myFriendList)
        binding.rvMyFriend.adapter = myFriendRVAdapter
        binding.rvMyFriend.layoutManager = LinearLayoutManager(requireActivity())


        binding.ivMyBack.setOnClickListener{
            parentFragmentManager.beginTransaction()
                .replace(R.id.fcv_my, MyMainFragment())
                .addToBackStack(null)
                .commit()
        }

        val editText = binding.etMyFriend
        val imm = requireContext().getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager

        editText.setOnFocusChangeListener { view, hasFocus ->
            if(hasFocus){
                imm.showSoftInput(view, InputMethodManager.SHOW_IMPLICIT)
            } else {
                imm.hideSoftInputFromWindow(view.windowToken, 0)
            }
        }

        editText.setOnEditorActionListener{ textView, i, keyEvent ->

            if(i == EditorInfo.IME_ACTION_SEARCH){
                val searchQuery = editText.text.toString()

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
    }

    private fun showDialog() {
        val message = "프래그먼트에 따라 다르게 설정된 메시지입니다."
        val dialog = DialogConfirmFragment.newInstance(message)
        dialog.show(parentFragmentManager, "MyDialogFragment")
    }

}
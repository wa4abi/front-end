package com.ku_rum.front_end.ui.theme.My

import android.widget.Button
import com.example.ku_rum.MyPage.MyFriendFragment
import com.example.ku_rum.MyPage.MyInformFragment
import com.example.ku_rum.MyPage.MyMoreFriendFragment
import com.example.ku_rum.MyPage.data.MyProfileData
import com.ku_rum.front_end.BaseFragment
import com.ku_rum.front_end.R
import com.ku_rum.front_end.databinding.FragmentMyMainBinding


class MyMainFragment : BaseFragment<FragmentMyMainBinding>(FragmentMyMainBinding::inflate) {

    var myProfileData = MyProfileData(0,"쿠룸", "공과대학","컴퓨터공학부 21학번","김민우")

    override fun initAfterBinding() {

        binding.etMyPageId.setText(myProfileData.id)
        binding.etMyPageName.setText(myProfileData.name)
        binding.etMyPageMajor.setText(myProfileData.major)
        binding.etMyPageCollege.setText(myProfileData.college)

//        내 정보 편집 기능
//        val btnMyPageEdit : Button = binding.btnMyPageEdit
//        btnMyPageEdit.setOnClickListener {
//            binding.etMyPageId.isEnabled = true
//            binding.etMyPageName.isEnabled = true
//            binding.etMyPageMajor.isEnabled = true
//            binding.etMyPageCollege.isEnabled = true
//        }

        val btnLogout : Button = binding.btnMyPageLogout
        btnLogout.setOnClickListener{
            // 내 프로필 정보 삭제?
        }

        binding.btnMyPageMyFriend.setOnClickListener{
            parentFragmentManager.beginTransaction()
                .replace(R.id.fcv_my, MyFriendFragment())
                .addToBackStack(null)
                .commit()
        }
        binding.btnMyPageMoreFriend.setOnClickListener{
            parentFragmentManager.beginTransaction()
                .replace(R.id.fcv_my, MyMoreFriendFragment())
                .addToBackStack(null)
                .commit()
        }
        binding.ivMyPageAlarm.setOnClickListener{
            parentFragmentManager.beginTransaction()
                .replace(R.id.fcv_my, MyInformFragment())
                .addToBackStack(null)
                .commit()
        }

    }
}
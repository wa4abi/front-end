package com.ku_rum.front_end.ui.theme.My

import android.os.Bundle
import android.widget.Button
import com.ku_rum.front_end.BaseFragment
import com.ku_rum.front_end.databinding.FragmentMyBinding

class MyFragment : BaseFragment<FragmentMyBinding>(FragmentMyBinding::inflate){
    override fun initAfterBinding() {
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var binding = FragmentMyBinding.inflate(layoutInflater)

        // 내 프로필 정보 얻기

        val btnLogout : Button = binding.btnMyPageLogout
        btnLogout.setOnClickListener{
            // 내 프로필 정보 삭제?
        }

    }
}
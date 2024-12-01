package com.ku_rum.front_end.ui.theme.Map

import android.util.Log
import com.kakao.vectormap.KakaoMap
import com.kakao.vectormap.KakaoMapReadyCallback
import com.kakao.vectormap.MapLifeCycleCallback
import com.ku_rum.front_end.BaseFragment
import com.ku_rum.front_end.databinding.FragmentMapBinding


class MapFragment : BaseFragment<FragmentMapBinding>(FragmentMapBinding::inflate){
    override fun initAfterBinding() {

        binding.mvMap.start(object : MapLifeCycleCallback() {
            override fun onMapDestroy() {
                // 지도 API 가 정상적으로 종료될 때 호출됨
            }

            override fun onMapError(error: Exception) {
                // 인증 실패 및 지도 사용 중 에러가 발생할 때 호출됨
                Log.d("kakaoMap error", error.toString())
            }
        }, object : KakaoMapReadyCallback() {
            override fun onMapReady(kakaoMap: KakaoMap) {
                // 인증 후 API 가 정상적으로 실행될 때 호출됨
            }
        })

    }
}
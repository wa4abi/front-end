package com.ku_rum.front_end

import android.app.Application
import com.kakao.sdk.common.KakaoSdk
import com.kakao.vectormap.KakaoMapSdk

class KURumApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        // 다른 초기화 코드들

        // Kakao SDK 초기화
        KakaoSdk.init(this, getString(R.string.KAKAO_NATIVE_APP_KEY))
        KakaoMapSdk.init(this, getString(R.string.KAKAO_NATIVE_APP_KEY))
    }
}
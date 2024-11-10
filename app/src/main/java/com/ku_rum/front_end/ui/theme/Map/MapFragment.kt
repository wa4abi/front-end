package com.ku_rum.front_end

import android.content.res.Resources
import android.graphics.Bitmap
import android.graphics.Canvas
import android.util.Log
import android.util.TypedValue
import android.view.LayoutInflater
import android.view.View
import android.widget.TextView
import com.kakao.vectormap.KakaoMap
import com.kakao.vectormap.KakaoMapReadyCallback
import com.kakao.vectormap.LatLng
import com.kakao.vectormap.MapLifeCycleCallback
import com.kakao.vectormap.label.LabelLayerOptions
import com.kakao.vectormap.label.LabelOptions
import com.kakao.vectormap.label.LabelStyle
import com.kakao.vectormap.label.LabelStyles
import com.kakao.vectormap.label.LabelTextBuilder
import com.kakao.vectormap.label.LabelTextStyle
import com.kakao.vectormap.label.TransformMethod
import com.ku_rum.front_end.databinding.FragmentMapBinding


class MapFragment : BaseFragment<FragmentMapBinding>(FragmentMapBinding::inflate) {
    private var kakaoMap: KakaoMap? = null

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
            override fun onMapReady(map: KakaoMap) {
                // 인증 후 API 가 정상적으로 실행될 때 호출됨
                kakaoMap = map
                labelSetting()

/*
                // 1. LabelStyles 생성하기 - Icon 이미지 하나만 있는 스타일
                val bike_styles = kakaoMap!!.labelManager
                    ?.addLabelStyles(
                        LabelStyles.from(
                            LabelStyle.from(R.drawable.map_label_bike).setAnchorPoint(0.5f, 0.5f)
                                .setApplyDpScale(true)
                        )
                    )


                // 2. LabelOptions 생성하기
                val bike_options = LabelOptions.from(LatLng.from(37.542155, 127.077503))
                    .setStyles(bike_styles)


                // 3. LabelLayer 가져오기 (또는 커스텀 Layer 생성)
                val layer = kakaoMap!!.labelManager!!.layer

                // 4. LabelLayer 에 LabelOptions 을 넣어 Label 생성하기
                val label = layer!!.addLabel(bike_options)

                // 라벨 크기 조정
                label.scaleTo(0.3f, 0.3f)

 */


            }

            override fun getPosition(): LatLng {
                return LatLng.from(37.542361, 127.077455)
            }
        })


    }


    // label 아이콘 추가
    private fun labelSetting() {
        val labelInfoMap = mutableMapOf<LabelCategory, LabelInfo>()

        labelInfoMap[LabelCategory.BIKE] = LabelInfo(
            LabelStyle.from(R.drawable.map_label_bike),
            "따릉이",
            mutableListOf(LatLng.from(37.542155, 127.077503))
        )

        labelInfoMap[LabelCategory.RESTAURANT] = LabelInfo(
            LabelStyle.from(R.drawable.map_label_restaurant),
            "학생식당",
            mutableListOf(LatLng.from(37.541683, 127.077918))
        )


        labelInfoMap[LabelCategory.K_CUBE] = LabelInfo(
            LabelStyle.from(R.drawable.map_label_bike),
            "K-CUBE",
            mutableListOf(LatLng.from(37.541690, 127.078856))
        )

        labelInfoMap[LabelCategory.CONVENIENCE_STORE]= LabelInfo(
            LabelStyle.from(R.drawable.map_label_convenience_store),
            "편의점",
            mutableListOf(LatLng.from(37.541711, 127.078157))
        )


        // 각 카테고리 별로 생성
        labelInfoMap.forEach { labelCategory, labelInfo ->
            // style 기본 설정
            labelInfo.labelStyle.setAnchorPoint(0.5f, 0.5f).setApplyDpScale(true)
                .setTextStyles((LabelTextStyle.from(20, R.color.black)))

            // LabelStyles 설정
            var labelStyles =
                kakaoMap?.labelManager?.addLabelStyles(LabelStyles.from(labelInfo.labelStyle))
            kakaoMap!!.labelManager!!.addLayer(LabelLayerOptions.from().setLodRadius(1f))
            var lodLabelLayer = kakaoMap!!.labelManager!!.lodLayer!!

            // 여러개의 label들을 LatLng 기준으로 여러개 생성해서 만들기
            labelInfo.latLngList.forEach { lng ->
                // LabelOptions 생성
                val options = LabelOptions.from(lng)
                    .setStyles(labelStyles)
                    .setTexts(LabelTextBuilder().setTexts(labelInfo.text))

                // LabelLayer 에 LabelOptions 을 넣어 Label 생성하기
                lodLabelLayer.addLodLabel(options)
            }



        }


    }
}

enum class LabelCategory {
    BIKE, RESTAURANT, CONVENIENCE_STORE, K_CUBE
}


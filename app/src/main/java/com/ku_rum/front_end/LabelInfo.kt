package com.ku_rum.front_end

import com.kakao.vectormap.LatLng
import com.kakao.vectormap.label.LabelOptions
import com.kakao.vectormap.label.LabelStyle

data class LabelInfo(
    var labelStyle: LabelStyle,
    var text: String,
    var latLngList: MutableList<LatLng>

    )

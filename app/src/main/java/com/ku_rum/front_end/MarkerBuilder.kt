package com.ku_rum.front_end

import android.content.res.Resources
import com.naver.maps.geometry.LatLng
import com.naver.maps.map.NaverMap
import com.naver.maps.map.overlay.Marker
import com.naver.maps.map.overlay.OverlayImage

class MarkerBuilder {
    private var position: LatLng = LatLng(0.0, 0.0)
    private var icon: OverlayImage = OverlayImage.fromResource(R.drawable.map_label_bike)
    private var width: Int = 0
    private var height: Int = 0
    private var captionText: String = ""
    private var captionTextSize: Float = 0f

    fun setPosition(latLng: LatLng): MarkerBuilder {
        this.position = latLng
        return this
    }

    fun setIcon(resourceId: Int): MarkerBuilder {
        this.icon = OverlayImage.fromResource(resourceId)
        return this
    }

    fun setSize(dpWidth: Int, dpHeight: Int): MarkerBuilder {
        this.width = convertDPtoPX(dpWidth)
        this.height = convertDPtoPX(dpHeight)
        return this
    }

    fun setCaption(text: String, textSize: Float): MarkerBuilder {
        this.captionText = text
        this.captionTextSize = textSize
        return this
    }

    fun build(naverMap: NaverMap): Marker {
        val marker = Marker()
        marker.position = position
        marker.icon = icon
        marker.width = width
        marker.height = height
        marker.captionText = captionText
        marker.captionTextSize = captionTextSize
        marker.map = naverMap
        return marker
    }

    private fun convertDPtoPX(dp: Int): Int {
        val density = Resources.getSystem().displayMetrics.density
        return (dp * density).toInt()
    }
}
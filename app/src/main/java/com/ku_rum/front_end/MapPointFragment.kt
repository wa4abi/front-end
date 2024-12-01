package com.ku_rum.front_end

import androidx.annotation.UiThread
import com.ku_rum.front_end.databinding.FragmentMapBinding
import com.naver.maps.geometry.LatLng
import com.naver.maps.map.CameraPosition
import com.naver.maps.map.MapFragment
import com.naver.maps.map.NaverMap
import com.naver.maps.map.NaverMapOptions
import com.naver.maps.map.OnMapReadyCallback


class MapPointFragment : BaseFragment<FragmentMapBinding>(FragmentMapBinding::inflate),
    OnMapReadyCallback {
    lateinit var mapFragment :MapFragment
    override fun initAfterBinding() {
        initNaverMap()
    }



    private fun initNaverMap() {
        val options = NaverMapOptions()
            .camera(CameraPosition(LatLng(37.542317, 127.077461), 16.0))
            .mapType(NaverMap.MapType.Terrain)
        val sfm = childFragmentManager

        mapFragment = sfm.findFragmentById(binding.mvMap.id) as MapFragment?
            ?: MapFragment.newInstance(options).also {
                sfm.beginTransaction().add(R.id.map, it).commit()
            }
        mapFragment.getMapAsync(this)
    }


    @UiThread
    override fun onMapReady(naverMap: NaverMap) {
//        val cameraUpdate = CameraUpdate.scrollTo(LatLng(37.542317, 127.077461))
//        naverMap.moveCamera(cameraUpdate)

        MarkerBuilder()
            .setPosition(LatLng(37.542209, 127.077509))
            .setIcon(R.drawable.map_label_bike)
            .setSize(25, 25)
            .setCaption("따릉이", 9f)
            .build(naverMap)
    }

}


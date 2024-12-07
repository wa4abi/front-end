package com.ku_rum.front_end.ui.theme.Main

import androidx.activity.OnBackPressedCallback
import com.ku_rum.front_end.ui.theme.Announcement.AnnouncementFragment
import com.ku_rum.front_end.BaseActivity
import com.ku_rum.front_end.ui.theme.Map.MapFragment
import com.ku_rum.front_end.R
import com.ku_rum.front_end.ui.theme.Reservation.ReservationFragment
import com.ku_rum.front_end.databinding.ActivityMainBinding
import com.ku_rum.front_end.ui.theme.My.MyFragment

class MainActivity: BaseActivity<ActivityMainBinding>(ActivityMainBinding::inflate) {

    private lateinit var navItem: NavigationItem
    private var backPressedTime: Long = 0L

    override fun initAfterBinding() {
        initOnBackPressedDispatcher()
        initBottomNavigation()
    }


    private fun initOnBackPressedDispatcher() {
        val onBackPressedCallback = object : OnBackPressedCallback(true) {

            override fun handleOnBackPressed() {
                when (binding.mainBottomNav.selectedItemId) {
                    R.id.announcement -> {
                        if (System.currentTimeMillis() - backPressedTime <= 2000) finishAffinity()
                        else backPressedTime = System.currentTimeMillis()
                    }

                    else ->
                        binding.mainBottomNav.selectedItemId = R.id.announcement
                }
            }
        }

        onBackPressedDispatcher.addCallback(onBackPressedCallback)
    }



    private fun initBottomNavigation() {
        binding.mainBottomNav.selectedItemId = R.id.announcement
        navItem = NavigationItem.ANNOUNCEMENT

        supportFragmentManager
            .beginTransaction()
            .replace(
                R.id.main_frm,
                AnnouncementFragment()
            )
            .commitAllowingStateLoss()

        binding.mainBottomNav.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.announcement -> {
                    navItem = NavigationItem.ANNOUNCEMENT

                    supportFragmentManager
                        .beginTransaction()
                        .replace(
                            R.id.main_frm,
                            AnnouncementFragment()
                        )
                        .commitAllowingStateLoss()
                    return@setOnItemSelectedListener true
                }

                R.id.map -> {
                    navItem = NavigationItem.MAP

                    supportFragmentManager
                        .beginTransaction()
                        .replace(
                            R.id.main_frm,
                            MapFragment()
                        )
                        .commitAllowingStateLoss()
                    return@setOnItemSelectedListener true
                }

                R.id.reservation -> {
                    navItem = NavigationItem.RESERVATION

                    supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.main_frm, ReservationFragment())
                        .commitAllowingStateLoss()
                    return@setOnItemSelectedListener true
                }

                R.id.my -> {
                    navItem = NavigationItem.MY

                    supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.main_frm, MyFragment())
                        .commitAllowingStateLoss()
                    return@setOnItemSelectedListener true
                }
            }
            false
        }
    }


    enum class NavigationItem {
        ANNOUNCEMENT, MAP, RESERVATION, MY;
    }
}

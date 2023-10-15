package com.example.music_player

import android.annotation.SuppressLint
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.viewpager2.adapter.FragmentStateAdapter
//FragmentStateAdapter được sử dụng để quản lý việc hiển thị các Fragment trong một ViewPager
class ViewPagerAdapter(activity: FragmentActivity) : FragmentStateAdapter(activity) {

    private val fragments = mutableListOf<Fragment>()
    // cập nhật danh sách các Fragment mới
    @SuppressLint("NotifyDataSetChanged")
    fun setFragments(newFragments: List<Fragment>) {
        fragments.clear()
        fragments.addAll(newFragments)
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
       return fragments.size
    }

    override fun createFragment(position: Int): Fragment {
            return fragments[position]
    }
}
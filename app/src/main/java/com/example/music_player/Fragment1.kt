package com.example.music_player

import android.os.Bundle
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView
import androidx.fragment.app.Fragment

class Fragment1 : Fragment(R.layout.activity_musicbg) {
    private var isFragmentVisible = false
    private var animation: Animation? = null
    private lateinit var imgsong: ImageView

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        imgsong = view.findViewById(R.id.imgsong) // Ánh xạ imgsong trong onViewCreated
    }

    //Quản lý hoạt động của fragment
    // hiển thị
    override fun onResume() {
        super.onResume()
        // Fragment đang hiển thị
        isFragmentVisible = true
        if (isFragmentVisible) {
            startImgSongAnimation()
        }
    }
    //Quản lý hoạt động của fragment
    override fun onPause() {
        super.onPause()
        isFragmentVisible = false
        stopImgSongAnimation()
    }

    private fun startImgSongAnimation() {
        // Khởi tạo và chạy animation cho imgsong
        animation = AnimationUtils.loadAnimation(requireContext(), R.anim.rotate)
        imgsong.startAnimation(animation)
    }

    private fun stopImgSongAnimation() {
        // Dừng animation của imgsong nếu đang chạy
        animation?.cancel()
        imgsong.clearAnimation()
    }
}
package com.example.music_player

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.fragment.app.Fragment

class Fragment2(private var arraysong: ArrayList<OutData>, private var position: Int) : Fragment(R.layout.activity_lyris) {
    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
             updateLyrics()
    }

    @SuppressLint("SetTextI18n")
    fun updateLyrics() {
        if (position >= 0 && position < arraysong.size) {
            view?.findViewById<TextView>(R.id.txtlyrics)?.text = arraysong[position].Lyrics
        } else {
            view?.findViewById<TextView>(R.id.txtlyrics)?.text = "Không có lời bài hát"
        }
    }
}












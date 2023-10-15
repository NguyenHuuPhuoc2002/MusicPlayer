package com.example.music_player

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RvAdapter(val ds:List<OutData>, val onMusicClick: Rvinterface) : RecyclerView.Adapter<RvAdapter.MusicViewHolder>(){
    inner class MusicViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MusicViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.layoutitem, parent, false)
        return MusicViewHolder(view)
    }

    override fun onBindViewHolder(holder: RvAdapter.MusicViewHolder, position: Int) {
        holder.itemView.apply {
           // findViewById<ImageView>(R.id.imgmusic).setImageResource(ds[position].image)
            findViewById<TextView>(R.id.txttitle).text = ds[position].title
            findViewById<TextView>(R.id.txtsinger).text = ds[position].casi

            //lắng nghe sự kiện
            holder.itemView.setOnClickListener {
                onMusicClick.Onclickmusic(position)
            }
        }
    }
    override fun getItemCount(): Int {
        return ds.size
    }
}
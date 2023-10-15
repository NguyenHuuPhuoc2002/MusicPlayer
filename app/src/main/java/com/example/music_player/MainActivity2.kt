package com.example.music_player

import android.annotation.SuppressLint
import android.content.Intent
import android.icu.text.SimpleDateFormat
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.SeekBar
import android.widget.TextView
import androidx.viewpager2.widget.ViewPager2
import java.util.Locale
import kotlin.properties.Delegates

class MainActivity2 : AppCompatActivity() {
    private lateinit var btnpre: ImageButton
    private lateinit var btnplay: ImageButton
    private lateinit var btnNext: ImageButton
    private lateinit var btnff: ImageButton
    private lateinit var btnfr: ImageButton
    private lateinit var imgbtnback: ImageButton
    private lateinit var txtsn: TextView
    private lateinit var txtsinger: TextView
    private lateinit var txtsstart: TextView
    private lateinit var txtsstop: TextView
    private lateinit var seekbar: SeekBar
    private lateinit var animation: Animation
    private var mediaPlayer: MediaPlayer? = null
    private lateinit var arraysong: ArrayList<OutData>
    private var position by Delegates.notNull<Int>()
    private var songDurationHandler: Handler? = null
    private var autoNextSongEnabled = true
    private lateinit var viewPager: ViewPager2
    private lateinit var adapter: ViewPagerAdapter

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_player)
        AnhXa()
        bundle()
        setup()
        UpDate_seekbar()
        updateSongDuration()
        btnprevSong()
        btnplay()
        btnNextSong()
        btnff()
        btnfr()
        seekbar()
        imgbtnback()
        Fragment2()
        auto_NextSong()
    }
    private fun Fragment2(){
        viewPager = findViewById(R.id.viewPager)
        adapter = ViewPagerAdapter(this)
        viewPager.adapter = adapter
        // Tạo danh sách fragments chứa hai Fragment
        val fragments = listOf(Fragment1(), Fragment2(arraysong, position))
        //thiết lập danh sách các Fragment mới cho adapter
        adapter.setFragments(fragments)
    }
    private fun imgbtnback(){
        imgbtnback.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            mediaPlayer?.stop()
            startActivity(intent)
        }
    }
    private fun setup(){
        btnplay.setBackgroundResource(R.drawable.ic_pause)
        mediaPlayer = MediaPlayer.create(this@MainActivity2, arraysong[position].file)
        mediaPlayer?.start()

    }
    private fun bundle(){
        val intent = intent
        val bundle = intent.extras
        if (bundle != null) {
            position = bundle.getInt("position", 0) // Lấy vị trí bài hát từ intent
            val txtSN = bundle.getString("txtsn")
            val txtSinger = bundle.getString("txtsinger")
            arraysong = intent.getSerializableExtra("arraysong") as java.util.ArrayList<OutData> // Sử dụng java.util.ArrayList
            txtsn.text = txtSN
            txtsinger.text = txtSinger
        }
    }

    private fun auto_NextSong() {
        mediaPlayer?.setOnCompletionListener {
            // Nếu bài hát phát xong, tự động chuyển sang bài tiếp theo
            if (autoNextSongEnabled) {
                if (position < arraysong.size - 1) {
                    position++
                    Fragment2()
                }else {
                    // Nếu đang ở bài hát cuối cùng trong danh sách, quay lại bài hát đầu tiên
                    position = 0
                }
            }
            mediaPlayer?.stop()
            mediaPlayer?.release()
            mediaPlayer = MediaPlayer.create(this@MainActivity2, arraysong[position].file)
            mediaPlayer?.start()
            txtsn.text = arraysong[position].title
            txtsinger.text = arraysong[position].casi
            seekbar.max = mediaPlayer?.duration ?: 0
            seekbar.progress = 0
            updateSongDuration()
            UpDate_seekbar()
            auto_NextSong()
        }
    }

    private fun btnNextSong(){
        btnNext.setOnClickListener {
            if (position < arraysong.size - 1) {
                position++
                Fragment2()
            }else
            {
                position = 0
                Fragment2()
            }
            mediaPlayer?.stop()
            mediaPlayer = MediaPlayer.create(this@MainActivity2, arraysong[position].file)
            mediaPlayer?.start()
            txtsn.text = arraysong[position].title
            txtsinger.text = arraysong[position].casi
            seekbar.max = mediaPlayer?.duration ?: 0 // Cập nhật giá trị max cho thanh seekbar
            seekbar.progress = 0
           // SettimeTotal()
            updateSongDuration()
            UpDate_seekbar()
            auto_NextSong()

        }
    }
    private fun btnprevSong(){
        btnpre.setOnClickListener {
            if (position > 0) {
                position--
                mediaPlayer?.stop()
                mediaPlayer = MediaPlayer.create(this@MainActivity2, arraysong[position].file)
                mediaPlayer?.start()
                txtsn.text = arraysong[position].title
                txtsinger.text = arraysong[position].casi
                seekbar.max = mediaPlayer?.duration ?: 0 // Cập nhật giá trị max cho thanh seekbar
                seekbar.progress = 0
                updateSongDuration()
                UpDate_seekbar()
                auto_NextSong()
                Fragment2()

            }else{
                position = arraysong.size - 1
                mediaPlayer?.stop()
                mediaPlayer = MediaPlayer.create(this@MainActivity2, arraysong[position].file)
                mediaPlayer?.start()
                txtsn.text = arraysong[position].title
                txtsinger.text = arraysong[position].casi
                seekbar.max = mediaPlayer?.duration ?: 0 // Cập nhật giá trị max cho thanh seekbar
                seekbar.progress = 0
                updateSongDuration()
                UpDate_seekbar()
                auto_NextSong()
                Fragment2()
            }
        }
    }
    private fun btnplay(){
        btnplay.setOnClickListener {
            if (mediaPlayer?.isPlaying == true) {
                mediaPlayer?.pause()
                btnplay.setBackgroundResource(R.drawable.ic_play)
                val imgsong = findViewById<ImageView>(R.id.imgsong)
                if(imgsong != null){
                    imgsong.clearAnimation()
                }else{
                    return@setOnClickListener
                }
            } else {
                mediaPlayer?.start()
                btnplay.setBackgroundResource(R.drawable.ic_pause)
                val imgsong = findViewById<ImageView>(R.id.imgsong)
                if(imgsong != null){
                    animation = AnimationUtils.loadAnimation(this, R.anim.rotate)
                    imgsong.startAnimation(animation)
                }else{
                    return@setOnClickListener
                }
            }
        }
    }
    private fun btnff(){
        btnff.setOnClickListener {
            if (mediaPlayer?.isPlaying == true) {
                val currentPosition = mediaPlayer?.currentPosition ?: 0
                // Tua tới 10 giây
                mediaPlayer?.seekTo(currentPosition + 10000)
            }
        }
    }
    private fun btnfr(){
        btnfr.setOnClickListener {
            if (mediaPlayer?.isPlaying == true) {
                val currentPosition = mediaPlayer?.currentPosition ?: 0
                // Tua lùi 10 giây
                mediaPlayer?.seekTo(currentPosition - 10000)
            }
        }
    }
    private fun seekbar(){
        seekbar.max = mediaPlayer?.duration ?: 0
        seekbar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {}

            override fun onStartTrackingTouch(seekBar: SeekBar?) {}

            override fun onStopTrackingTouch(seekBar: SeekBar) {
                //đặt thời gian phát của bài hát tới giá trị tiến trình hiện tại của SeekBar
                mediaPlayer?.seekTo(seekBar.progress)
            }
        })
    }
    private fun UpDate_seekbar(){
        val handler = Handler(Looper.getMainLooper())
        handler.postDelayed(object : Runnable {
            override fun run() {
                if (mediaPlayer != null) {
                    seekbar.progress = mediaPlayer!!.currentPosition
                }
                handler.postDelayed(this, 1000)
            }
        }, 0)
    }
    private fun updateSongDuration() {
        // Xóa handler cũ trước khi tạo handler mới
        songDurationHandler?.removeCallbacksAndMessages(null)
        //xử lí kiểm tra xem mediaPlayer có giá trị không null
        mediaPlayer?.let {
            // Lấy thời lượng tổng cộng của bài hát đang phát (duration)
            val totalDuration = it.duration
            val format = SimpleDateFormat("m:ss", Locale.getDefault())
            val formattedTime = format.format(totalDuration.toLong())
            txtsstop.text = formattedTime

            // Tạo handler mới để cập nhật thời gian bài hát
            songDurationHandler = Handler(Looper.getMainLooper())
            //đưa hàng đợi vào luồng chính
            songDurationHandler?.post(object : Runnable {
                override fun run() {
                    val currentPosition = it.currentPosition
                    val formattedCurrentTime = format.format(currentPosition.toLong())
                    txtsstart.text = formattedCurrentTime

                    // Tiếp tục cập nhật thời gian
                    songDurationHandler?.postDelayed(this, 1000)
                }
            })
        }
    }
    override fun onDestroy() {
        super.onDestroy()
        mediaPlayer?.release()
        mediaPlayer = null
    }

    private fun AnhXa() {
        // Ánh xạ các view
        btnpre = findViewById(R.id.btnprev)
        btnff = findViewById(R.id.btnff)
        btnfr = findViewById(R.id.btnfr)
        btnNext = findViewById(R.id.btnnext)
        imgbtnback = findViewById(R.id.imgbtnback)
        btnplay = findViewById(R.id.playbtn)
        txtsstop = findViewById(R.id.txtsstop)
        txtsstart = findViewById(R.id.txtsstart)
        seekbar = findViewById(R.id.seekbar)
        txtsn = findViewById(R.id.txtsn)
        txtsinger = findViewById(R.id.txtsinger)
    }

}
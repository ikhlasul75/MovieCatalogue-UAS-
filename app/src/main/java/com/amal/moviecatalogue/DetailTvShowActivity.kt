package com.amal.moviecatalogue

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_detail_movie.*

class DetailTvShowActivity : AppCompatActivity() {
    companion object {
        const val EXTRA_DATA = "extra_data"
    }

    var tvshow : TvShow? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_tv_show)

        tvshow = intent.getParcelableExtra(EXTRA_DATA)

        tv_title.text = tvshow?.name
        tv_overview.text = tvshow?.overview
        tv_rating.text = tvshow?.popularity
        Glide.with(img_poster).load(IMAGE_BASE +
                tvshow!!.poster).into(img_poster)
    }
}
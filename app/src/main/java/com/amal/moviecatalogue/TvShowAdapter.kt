package com.amal.moviecatalogue

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.tvshow_item.view.*

class TvShowAdapter(
    private val tvshow: List<TvShow>, val listener: OnAdapterListener
) : RecyclerView.Adapter<TvShowAdapter.TvShowViewHolder>(){

    class TvShowViewHolder (view: View) : RecyclerView.ViewHolder(view) {
        fun bindTvShow(tvshow : TvShow) {
            itemView.tvshow_name.text = tvshow.name
            itemView.tvshow_popularity.text = tvshow.popularity
            itemView.tvshow_release_date.text = tvshow.release

            Glide.with(itemView).load(IMAGE_BASE + tvshow.poster)
                .into(itemView.tvshow_poster)
            Log.e("TvShowAdapter", "URL Image ==> $IMAGE_BASE${tvshow.poster}")
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TvShowViewHolder {
        return TvShowViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.tvshow_item, parent, false)
        )
    }

    override fun getItemCount(): Int = tvshow.size

    override fun onBindViewHolder(holder: TvShowViewHolder, position: Int) {
        holder.bindTvShow(tvshow[position])
        holder.itemView.setOnClickListener { listener.onClick(tvshow[position]) }
    }
    interface OnAdapterListener {
        fun onClick(result: TvShow)
    }
}
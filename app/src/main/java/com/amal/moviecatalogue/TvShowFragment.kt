package com.amal.moviecatalogue

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_movie.*
import kotlinx.android.synthetic.main.fragment_tv_show.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class TvShowFragment : Fragment() {
    var tvshow: List<TvShow>? = null
    private lateinit var tvShowAdapter: TvShowAdapter

    companion object {
        fun newInstance() = TvShowFragment()
    }



    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? { return inflater.inflate(R.layout.fragment_tv_show, container, false) }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        rv_tvshow_list.layoutManager = LinearLayoutManager(activity)
        rv_tvshow_list.setHasFixedSize(true)
        getMovieData { tvshow: List<TvShow> ->
            rv_tvshow_list.adapter = TvShowAdapter(tvshow, object :TvShowAdapter.OnAdapterListener {

                override fun onClick(result: TvShow) {
                    val intent = Intent(activity, DetailTvShowActivity::class.java)
                    intent.putExtra(DetailTvShowActivity.EXTRA_DATA, result)
                    startActivity(intent)
                }
            })
        }
    }
    private fun setupRecyclerView(){
        tvShowAdapter = TvShowAdapter(arrayListOf(),
            object : TvShowAdapter.OnAdapterListener {
                override fun onClick(result: TvShow) {
                    val intent = Intent(activity,
                        DetailTvShowActivity::class.java)
                    intent.putExtra(DetailTvShowActivity.EXTRA_DATA,
                        result)
                    startActivity(intent)
                }
            })
        rv_tvshow_list.apply {
            layoutManager =
                LinearLayoutManager(context)
            adapter = tvShowAdapter
        }
    }

    private fun getMovieData(callback: (List<TvShow>) -> Unit){
        val apiService = TvShowApiService.getInstance().create(TvShowApiInterface::class.java)
        apiService.getTvShowList().enqueue(object : Callback<TvShowResponse> {
            override fun onFailure(call: Call<TvShowResponse>, t: Throwable) {

            }

            override fun onResponse(call: Call<TvShowResponse>, response: Response<TvShowResponse>) {
                tvshow = response.body()!!.tvshow
                return callback(response.body()!!.tvshow)
            }

        })
    }


}
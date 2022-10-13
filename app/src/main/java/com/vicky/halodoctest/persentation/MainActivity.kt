package com.vicky.halodoctest.persentation


import android.R.attr.data


import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.widget.GridView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.vicky.halodoctest.R
import com.vicky.halodoctest.model.ImageResultModel
import com.vicky.halodoctest.network.NetworkHelper
import com.vicky.halodoctest.network.RetrofitBuilder



class MainActivity : AppCompatActivity() {
    private lateinit var gridAdapter: GridAdapter
    private lateinit var gridView: GridView
    private lateinit var mainViewModel: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setUi()
        setViewModel() // use Dagger 2
        setDataObserver()


    }

    private fun setUi() {
        gridView = findViewById(R.id.imgGridView)
        gridAdapter = GridAdapter(this, arrayListOf())
        gridView.adapter = gridAdapter
    }

    private fun setDataObserver() {
        mainViewModel.getImages().observe(this) {
            setDataToRecyclerView(it)
        }
    }

    private fun setDataToRecyclerView(it: List<ImageResultModel>?) { // same data model using we can change using map function
        //Add data to adapter
        gridAdapter.addData(it!!)
        gridAdapter.notifyDataSetChanged()

    }

    private fun setViewModel() {
        mainViewModel = ViewModelProvider(this)[MainViewModel::class.java]
    }
}
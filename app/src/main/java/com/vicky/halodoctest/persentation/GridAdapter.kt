package com.vicky.halodoctest.persentation


import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso
import com.vicky.halodoctest.R
import com.vicky.halodoctest.model.ImageResultModel
import com.vicky.halodoctest.persentation.Fullscreen.Companion.IMAGE_URL


class GridAdapter(private val context: Context, private val list: ArrayList<ImageResultModel>) : BaseAdapter() {
        @SuppressLint("ViewHolder")
        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {



            val convertView = LayoutInflater.from(context).inflate(R.layout.image_row_layout, null)
            val imageview: ImageView = convertView.findViewById(R.id.imageView) as ImageView
            val textview = convertView.findViewById(R.id.textView) as TextView

            textview.text = getItem(position).id.toString()

            Picasso
                .get()
                .load(getItem(position).download_url)
                .resize(100, 100)
                .noFade()
                .into(imageview);

            imageview.setOnClickListener {
                val intent = Intent(parent?.context,Fullscreen::class.java)
                intent.putExtra(IMAGE_URL , getItem(position).download_url)
                parent?.context?.startActivity(intent)
            }

            return convertView
        }

        override fun getItem(position: Int): ImageResultModel = list.get(position)

        override fun getItemId(position: Int): Long = 0

        override fun getCount(): Int = list.size

    fun addData(imageResultModels: List<ImageResultModel>) {
        list.clear()
        var reverse = false

        for( i in 0..74 step 4){
            if(reverse){
                list.add(imageResultModels[i+3])
                list.add(imageResultModels[i+2])
                list.add(imageResultModels[i+1])
                list.add(imageResultModels[i])
            }else{
                list.add(imageResultModels[i])
                list.add(imageResultModels[i+1])
                list.add(imageResultModels[i+2])
                list.add(imageResultModels[i+3])
            }
            reverse = !reverse
        }

        // Temp solution this can done using gridLayout manager
        //list.addAll(imageResultModels.take(75)
    }
    }
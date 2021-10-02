package com.robelseyoum.airvettakehomecoding.utils

import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.ProgressBar
import android.widget.TextView
import androidx.core.net.toUri
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.robelseyoum.airvettakehomecoding.R
import com.robelseyoum.airvettakehomecoding.data.api.RandomUserApiStatus
import com.robelseyoum.airvettakehomecoding.data.api.RandomUserApiStatus.*
import com.robelseyoum.airvettakehomecoding.data.model.Results
import com.robelseyoum.airvettakehomecoding.ui.randomuseroverview.RandomUserAdapter
import okhttp3.internal.notify


@BindingAdapter("listData")
fun bindRecyclerView(recyclerView: RecyclerView, data: List<Results>?) {
    val adapter = recyclerView.adapter as RandomUserAdapter
    data?.let { adapter.submitList(it) }
}


@BindingAdapter("randomNameString")
fun TextView.setStatusNameString(item: Results?) {
    val title = item?.name?.title
    val firstName = item?.name?.first
    val lastName = item?.name?.last
    val fullName = "$title $firstName $lastName"
    text = fullName
}

@BindingAdapter("imageUrl")
fun bindImage(imgView: ImageView, imgUrl: Results?) {
    imgUrl?.let {
        val imgUri = imgUrl.picture.large
        Glide.with(imgView.context)
            .load(imgUri)
            .apply(
                RequestOptions()
                    .placeholder(R.drawable.loading_animation)
                    .error(R.drawable.ic_broken_image)
            )
            .into(imgView)
    }
}

@BindingAdapter("progressRandomStatus")
fun bindProgressStatus(progressBar: ProgressBar, status: RandomUserApiStatus?) {
    when (status) {
        LOADING -> {
            progressBar.visibility = View.VISIBLE
        }
        ERROR -> {
            progressBar.visibility = View.GONE
        }
        DONE -> {
            progressBar.visibility = View.GONE
        }
    }
}

@BindingAdapter("errorApiStatus")
fun bindErrorStatus(layout: LinearLayout, status: RandomUserApiStatus?) {
    when (status) {
        LOADING -> {
            layout.visibility = View.GONE
        }
        ERROR -> {
            layout.visibility = View.VISIBLE
        }
        DONE -> {
            layout.visibility = View.GONE
        }
    }
}
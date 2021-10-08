package com.robelseyoum.airvettakehomecoding.utils

import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.ProgressBar
import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.robelseyoum.airvettakehomecoding.R
import com.robelseyoum.airvettakehomecoding.data.api.RandomUserApiStatus
import com.robelseyoum.airvettakehomecoding.data.api.RandomUserApiStatus.*
import com.robelseyoum.airvettakehomecoding.data.model.Person
import com.robelseyoum.airvettakehomecoding.data.model.Results
import com.robelseyoum.airvettakehomecoding.ui.randomuseroverview.RandomUserAdapter


@BindingAdapter("listData")
fun bindRecyclerView(recyclerView: RecyclerView, data: List<Results>?) {
    val adapter = recyclerView.adapter as RandomUserAdapter
    data?.let { adapter.submitList(it) }
}

@BindingAdapter("randomNameString")
fun TextView.setStatusNameString(item: Results?) {
    item?.let {
      val person = Person(it.name.title, it.name.first, it.name.last)
        text = "${person.title+" "+person.firstName+" "+person.lastName}"
    }
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

/** Detail User  zone start */

@BindingAdapter("detailGenderString")
fun TextView.setDetailGenderString(item: Results?) {
    item?.let { text = it.gender }
}

@BindingAdapter("detailCityString")
fun TextView.setDetailCityString(item: Results?) {
    item?.let { text = it.location.city}
}

@BindingAdapter("detailStateString")
fun TextView.setDetailStateString(item: Results?) {
    item?.let { text = it.location.state}
}

@BindingAdapter("detailCountryString")
fun TextView.setDetailCountryString(item: Results?) {
    item?.let { text = it.location.country}
}

/**  end Detail User  zone */
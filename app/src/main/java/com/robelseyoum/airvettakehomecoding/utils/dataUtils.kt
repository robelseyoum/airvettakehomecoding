package com.robelseyoum.airvettakehomecoding.utils

import android.text.format.DateUtils
import androidx.annotation.DrawableRes
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView

fun formatDurations(seconds: Long): String = if (seconds < 60) {
    seconds.toString()
} else { DateUtils.formatElapsedTime(seconds) }

enum class RandomUserApiStatus { LOADING, ERROR, DONE }

fun RecyclerView.setDivider(@DrawableRes drawableRes: Int) {
    val divider = DividerItemDecoration(
        this.context,
        DividerItemDecoration.VERTICAL
    )
    val drawable = ContextCompat.getDrawable(
        this.context,
        drawableRes
    )
    drawable?.let {
        divider.setDrawable(it)
        addItemDecoration(divider)
    }
}
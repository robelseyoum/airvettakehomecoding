package com.robelseyoum.airvettakehomecoding.data.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Street (
	@SerializedName("number") var number : Int,
	@SerializedName("name") var name : String
): Parcelable
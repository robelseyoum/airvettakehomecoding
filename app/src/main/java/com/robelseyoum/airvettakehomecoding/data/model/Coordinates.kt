package com.robelseyoum.airvettakehomecoding.data.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Coordinates (
	@SerializedName("latitude") var latitude : String,
	@SerializedName("longitude") var longitude : String
): Parcelable
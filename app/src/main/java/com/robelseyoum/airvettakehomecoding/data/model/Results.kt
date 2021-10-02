package com.robelseyoum.airvettakehomecoding.data.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Results(
    @SerializedName("gender") var gender: String,
    @SerializedName("name") var name: Name,
    @SerializedName("picture") var picture: Picture,
    @SerializedName("location") var location: Location
): Parcelable

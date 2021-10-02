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

/**
 *
data class Results (
@SerializedName("gender") var gender : String,
@SerializedName("name") var name : Name,
@SerializedName("location") var location : Location,
@SerializedName("email") var email : String,
@SerializedName("login") var login : Login,
@SerializedName("dob") var dob : Dob,
@SerializedName("registered") var registered : Registered,
@SerializedName("phone") var phone : String,
@SerializedName("cell") var cell : String,
@SerializedName("id") var id : Id,
@SerializedName("picture") var picture : Picture,
@SerializedName("nat") var nat : String
)

 */
package com.robelseyoum.airvettakehomecoding.data.model

import com.google.gson.annotations.SerializedName


data class Street (
	@SerializedName("number") var number : Int,
	@SerializedName("name") var name : String
)
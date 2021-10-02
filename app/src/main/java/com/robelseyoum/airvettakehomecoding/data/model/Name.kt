package com.robelseyoum.airvettakehomecoding.data.model

import com.google.gson.annotations.SerializedName


data class Name (
	@SerializedName("title") var title : String,
	@SerializedName("first") var first : String,
	@SerializedName("last") var last : String
)
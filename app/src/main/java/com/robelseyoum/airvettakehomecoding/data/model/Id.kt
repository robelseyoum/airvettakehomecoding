package com.robelseyoum.airvettakehomecoding.data.model

import com.google.gson.annotations.SerializedName

data class Id (
	@SerializedName("name") var name : String,
	@SerializedName("value") var value : String
)
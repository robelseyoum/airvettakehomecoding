package com.robelseyoum.airvettakehomecoding.data.model

import com.google.gson.annotations.SerializedName

data class Info (
	@SerializedName("street") var street : Street,
	@SerializedName("city") var city : String,
	@SerializedName("state") var state : String,
	@SerializedName("country") var country : String,
	@SerializedName("postcode") var postcode : Int,
)
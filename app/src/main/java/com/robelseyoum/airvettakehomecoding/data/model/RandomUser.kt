package com.robelseyoum.airvettakehomecoding.data.model

import com.google.gson.annotations.SerializedName

data class RandomUser (
    @SerializedName("results") val results : List<Results>,
    @SerializedName("info") val info : Info
)
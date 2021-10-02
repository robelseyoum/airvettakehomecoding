package com.robelseyoum.airvettakehomecoding.data.model

import com.google.gson.annotations.SerializedName

data class RandomUser (
    @SerializedName("results") var results : List<Results>,
    @SerializedName("info") var info : Info
)
package com.example.philcororetro.model

import com.google.gson.annotations.SerializedName


data class ActionsResponse (

    @SerializedName("actions")
    val actions: List<Action> = emptyList()

)



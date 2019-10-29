package com.example.kotlincrudapp.model

import com.google.gson.annotations.SerializedName

data class ResultUser(

	@field:SerializedName("pesan")
	val pesan: String? = null,

	@field:SerializedName("user")
	val user: List<UserItem?>? = null,

	@field:SerializedName("status")
	val status: Int? = null
)
package com.example.kotlincrudapp.model


import com.google.gson.annotations.SerializedName

data class UserItem(

	@field:SerializedName("alamat_user")
	val alamatUser: String? = null,

	@field:SerializedName("name_user")
	val nameUser: String? = null,

	@field:SerializedName("email_user")
	val emailUser: String? = null,

	@field:SerializedName("password_user")
	val passwordUser: String? = null,

	@field:SerializedName("id_user")
	val idUser: String? = null
)
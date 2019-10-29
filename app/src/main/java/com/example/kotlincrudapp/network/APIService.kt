package com.example.kotlincrudapp.network

import com.example.kotlincrudapp.model.ResultStatus
import com.example.kotlincrudapp.model.ResultUser
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface APIService {

    @GET("getDataUser")
    fun getData():Call<ResultUser>

    @FormUrlEncoded
    @POST("addUser")
    fun registerData(@Field("name")name:String,
                     @Field("address")alamat:String,
                     @Field("email")email:String,
                     @Field("password")password:String):Call<ResultStatus>

    @FormUrlEncoded
    @POST("updateUser")
    fun updateData(@Field("id")id:String,
                   @Field("name")name:String,
                   @Field("address")alamat:String,
                   @Field("email")email:String,
                   @Field("password")password:String):Call<ResultStatus>

    @FormUrlEncoded
    @POST("deleteUser")
    fun deleteData(@Field("id")id:String?):Call<ResultStatus>
}
package com.example.kotlincrudapp.presenter

import com.example.kotlincrudapp.model.UserItem

interface GlobalView {

    //utk getData
    fun onSuccessfulGet(data:List<UserItem?>?)
    fun onFailedGet(msg:String?)

    //utk delete
    fun onSuccessfulDelete(msg:String?)
    fun onErrorDelete(msg:String?)

    //utk add
    fun onSuccessfulAdd(msg:String?)
    fun onErrorAdd(msg:String)

    //utk update
    fun onSuccessfulUpdate(msg:String?)
    fun onErrorUpdate(msg:String?)

}
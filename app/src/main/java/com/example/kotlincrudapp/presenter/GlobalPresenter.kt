package com.example.kotlincrudapp.presenter

import android.provider.ContactsContract
import com.example.kotlincrudapp.model.ResultStatus
import com.example.kotlincrudapp.model.ResultUser
import com.example.kotlincrudapp.network.NetworkConfig
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class GlobalPresenter (val globalView: GlobalView){


    fun processToReadData(){
        NetworkConfig.useServiceApi()
            .getData()
            .enqueue(object :Callback<ResultUser>{
                override fun onFailure(call: Call<ResultUser>, t: Throwable) {
                    globalView.onFailedGet(t.localizedMessage)
                }

                override fun onResponse(call: Call<ResultUser>, response: Response<ResultUser>) {
                    if (response.body()?.status ==200){
                        globalView.onSuccessfulGet(response.body()?.user)
                    }else{
                        globalView.onFailedGet(response.body()?.pesan)
                    }
                }

            })
    }

    fun processToAddData(name: String,address:String,email: String,password: String){
        NetworkConfig.useServiceApi()
            .registerData(name,address,email,password)
            .enqueue(object :Callback<ResultStatus>{
                override fun onFailure(call: Call<ResultStatus>, t: Throwable) {
                    globalView.onErrorAdd(t.localizedMessage)
                }

                override fun onResponse(call: Call<ResultStatus>, response: Response<ResultStatus>) {
                    if (response.body()?.status ==200){
                        globalView.onSuccessfulAdd(response.body()?.pesan)
                    }else{
                        globalView.onFailedGet(response.body()?.pesan)
                    }
                }
            })

    }

    fun processToDeleteData(id:String?){
        NetworkConfig.useServiceApi()
            .deleteData(id)
            .enqueue(object :Callback<ResultStatus>{
                override fun onFailure(call: Call<ResultStatus>, t: Throwable) {
                    globalView.onErrorDelete(t.localizedMessage)
                }

                override fun onResponse(call: Call<ResultStatus>, response: Response<ResultStatus>) {
                    if (response.body()?.status ==200){
                        globalView.onSuccessfulDelete(response.body()?.pesan)
                    }else{
                        globalView.onErrorDelete(response.body()?.pesan)
                    }
                }
            })
    }


    fun processToUpdate(id: String,name: String,address:String,email: String,password: String){
        NetworkConfig.useServiceApi()
            .updateData(id,name,address,email,password)
            .enqueue(object :Callback<ResultStatus>{
                override fun onFailure(call: Call<ResultStatus>, t: Throwable) {
                    globalView.onErrorUpdate(t.localizedMessage)
                }

                override fun onResponse(call: Call<ResultStatus>, response: Response<ResultStatus>) {
                    if (response.body()?.status ==200){
                        globalView.onSuccessfulUpdate(response.body()?.pesan)
                    }else{
                        globalView.onErrorUpdate(response.body()?.pesan)
                    }
                }
            })
    }

}
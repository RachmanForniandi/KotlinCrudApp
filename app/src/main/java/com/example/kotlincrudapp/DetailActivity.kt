package com.example.kotlincrudapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.kotlincrudapp.model.UserItem
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val data = intent.getSerializableExtra("dataItem")as UserItem

        tvName.text = data.nameUser
        tvEmail.text = data.emailUser
        tvAddress.text = data.alamatUser
    }
}

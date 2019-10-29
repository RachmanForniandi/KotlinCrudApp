package com.example.kotlincrudapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.kotlincrudapp.adapter.UserAdapter
import com.example.kotlincrudapp.model.UserItem
import com.example.kotlincrudapp.presenter.GlobalPresenter
import com.example.kotlincrudapp.presenter.GlobalView
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.sdk27.coroutines.onClick
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.toast

class MainActivity : AppCompatActivity() ,GlobalView{

    private lateinit var globalPresenter: GlobalPresenter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        globalPresenter = GlobalPresenter(this)
        globalPresenter.processToReadData()


        btnAddUser.onClick {

        }
    }


    override fun onSuccessfulGet(data: List<UserItem?>?) {
        listItemUser.adapter = UserAdapter(data, object : UserAdapter.onClickItem {
            override fun onClicked(item: UserItem?) {
                //startActivity<DetailActivity>()
            }

            override fun onUpdate(item: UserItem?) {
                //startActivity<DetailActivity>("dataItem" to Item)
            }

            override fun onDelete(item: UserItem?) {
                globalPresenter.processToDeleteData(item?.idUser)
                startActivity<MainActivity>()
                finish()
            }

        })
    }

    override fun onFailedGet(msg: String?) {
        toast("Gagal Load Data").show()
    }

    override fun onSuccessfulDelete(msg: String?) {
        globalPresenter.processToReadData()
    }

    override fun onErrorDelete(msg: String?) {
        toast("Gagal Hapus Data").show()
    }

    override fun onSuccessfulAdd(msg: String?) {
        toast("Berhasil Tambah Data").show()
    }

    override fun onErrorAdd(msg: String) {
        toast("Gagal Tambah Data").show()
    }

    override fun onSuccessfulUpdate(msg: String?) {
        toast("Berhasil Update Data").show()
    }

    override fun onErrorUpdate(msg: String?) {
        toast("Gagal Update Data").show()
    }
}

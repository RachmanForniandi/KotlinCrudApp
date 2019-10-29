package com.example.kotlincrudapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.kotlincrudapp.model.UserItem
import com.example.kotlincrudapp.presenter.GlobalPresenter
import com.example.kotlincrudapp.presenter.GlobalView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_update_add.*
import org.jetbrains.anko.sdk27.coroutines.onClick
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.toast

class UpdateAddActivity : AppCompatActivity(),GlobalView {

    private lateinit var presenter: GlobalPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update_add)

        presenter = GlobalPresenter(this)

        val bundleData = intent.getSerializableExtra("dataItem")as UserItem

        if (bundleData == null){
            btnAction.text ="Tambah"
            btnAction.onClick {
                presenter.processToAddData(
                    etNamaUser.text.toString(),
                    etAlamatUser.text.toString(),
                    etEmailUser.text.toString(),
                    etPassword.text.toString()

                )
            }
        }else if (bundleData != null){
            btnAction.text ="Update"
            etNamaUser.setText(bundleData.nameUser.toString())
            etAlamatUser.setText(bundleData?.alamatUser.toString())
            etEmailUser.setText(bundleData?.emailUser.toString())
            etPassword.setText(bundleData?.passwordUser.toString())
            btnAction.onClick {
                presenter.processToUpdate(
                    bundleData.idUser ?:"",
                    etNamaUser.text.toString(),
                    etAlamatUser.text.toString(),
                    etEmailUser.text.toString(),
                    etPassword.text.toString()

                )
            }
        }

    }



    override fun onSuccessfulGet(data: List<UserItem?>?) {
    }

    override fun onFailedGet(msg: String?) {
    }

    override fun onSuccessfulDelete(msg: String?) {
    }

    override fun onErrorDelete(msg: String?) {
    }

    override fun onSuccessfulAdd(msg: String?) {
        startActivity<MainActivity>()
        finish()
    }

    override fun onErrorAdd(msg: String) {
        toast("Gagal Tambah Data").show()
    }

    override fun onSuccessfulUpdate(msg: String?) {
        toast("Berhasil Ubah Data").show()
    }

    override fun onErrorUpdate(msg: String?) {
        toast("Gagal Ubah Data").show()
    }
}

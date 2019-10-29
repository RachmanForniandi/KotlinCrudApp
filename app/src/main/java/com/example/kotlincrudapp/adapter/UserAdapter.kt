package com.example.kotlincrudapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlincrudapp.R
import com.example.kotlincrudapp.model.UserItem
import kotlinx.android.synthetic.main.item_user.view.*
import org.jetbrains.anko.sdk27.coroutines.onClick
import retrofit2.http.GET

class UserAdapter (val data: List<UserItem?>?,val clicked:onClickItem ): RecyclerView.Adapter<UserAdapter.UserHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserAdapter.UserHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_user,parent,false)
        return UserHolder(view)
    }

    override fun getItemCount(): Int {
        return data?.size ?:0
    }

    override fun onBindViewHolder(holder: UserAdapter.UserHolder, position: Int) {
        holder.onBind(data?.get(position))

        //utk ke detail
        holder.itemView.onClick {
            clicked.onClicked(data?.get(position))
        }


        //delete
        holder.itemView.btnDelete.onClick {
            clicked.onDelete(data?.get(position))
        }

        //update
        holder.itemView.btnUpdate.onClick {
            clicked.onUpdate(data?.get(position))
        }
    }

    class UserHolder (itemView: View):RecyclerView.ViewHolder(itemView){
        fun onBind(get:UserItem?){
            itemView.tvName.text = get?.nameUser
            itemView.tvEmail.text = get?.emailUser
        }

    }

    interface onClickItem {
        fun onClicked(item: UserItem?)
        fun onUpdate(item: UserItem?)
        fun onDelete(item: UserItem?)
    }
}
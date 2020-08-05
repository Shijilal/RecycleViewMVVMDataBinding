package com.lalsoft.recyclerviewmvvmdatabinding.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.lalsoft.recyclerviewmvvmdatabinding.R
import com.lalsoft.recyclerviewmvvmdatabinding.databinding.CardViewBinding
import com.lalsoft.recyclerviewmvvmdatabinding.model.User

class RecyclerAdapter() :RecyclerView.Adapter<RecyclerAdapter.GenericViewHolder>(){
    private lateinit var userArrayList :ArrayList<*>
    inner class GenericViewHolder(val cardViewBinding: CardViewBinding):
        RecyclerView.ViewHolder(cardViewBinding.root){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GenericViewHolder {
        val layoutInflater=LayoutInflater.from(parent.context)
        val dataBinding:CardViewBinding=
            DataBindingUtil.inflate(layoutInflater, R.layout.card_view,parent,false)
        return GenericViewHolder(dataBinding)
    }

    override fun getItemCount(): Int =userArrayList.size

    override fun onBindViewHolder(holder: GenericViewHolder, position: Int) {
        holder.cardViewBinding.mUser= userArrayList[position] as User?
    }

    fun setUserList(userList: ArrayList<*>) {
        this.userArrayList = userList
        notifyDataSetChanged()
    }
}
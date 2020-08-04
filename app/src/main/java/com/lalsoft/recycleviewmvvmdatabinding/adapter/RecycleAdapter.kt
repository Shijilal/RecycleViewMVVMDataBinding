package com.lalsoft.recycleviewmvvmdatabinding.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.lalsoft.recycleviewmvvmdatabinding.R
import com.lalsoft.recycleviewmvvmdatabinding.databinding.CardViewBinding
import com.lalsoft.recycleviewmvvmdatabinding.model.User

class RecycleAdapter() :RecyclerView.Adapter<RecycleAdapter.GenericViewHolder>(){
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
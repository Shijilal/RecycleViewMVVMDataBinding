package com.lalsoft.recycleviewmvvmdatabinding.viewmodel

import androidx.lifecycle.ViewModel
import com.lalsoft.recycleviewmvvmdatabinding.adapter.RecycleAdapter
import com.lalsoft.recycleviewmvvmdatabinding.data.Repository

class RecycleViewModel :ViewModel(){
    private val repository by lazy { Repository() }
    var adapter:RecycleAdapter?=null
    private set

    init {
        val userList=repository.getUserList()
        adapter?.setUserList(userList)
    }

}
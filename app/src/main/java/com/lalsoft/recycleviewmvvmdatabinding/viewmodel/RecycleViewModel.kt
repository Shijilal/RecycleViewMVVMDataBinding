package com.lalsoft.recycleviewmvvmdatabinding.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.lalsoft.recycleviewmvvmdatabinding.adapter.RecycleAdapter
import com.lalsoft.recycleviewmvvmdatabinding.data.Repository
import com.lalsoft.recycleviewmvvmdatabinding.model.User

class RecycleViewModel : ViewModel() {
    private val repository by lazy { Repository() }

    //    var adapter:RecycleAdapter?=null
//    private set
    private val _adapter: MutableLiveData<RecycleAdapter> = MutableLiveData()
    val adapter: LiveData<RecycleAdapter>
        get() = _adapter
    private val _userList: MutableLiveData<ArrayList<*>> = MutableLiveData()
    val userList: LiveData<ArrayList<*>>
        get() = _userList


    init {
        _userList.value = repository.getUserList()
        //_adapter.value?.setUserList(userList)
    }

}
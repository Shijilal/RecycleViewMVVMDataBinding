package com.lalsoft.recyclerviewmvvmdatabinding.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.lalsoft.recyclerviewmvvmdatabinding.adapter.RecyclerAdapter
import com.lalsoft.recyclerviewmvvmdatabinding.data.Repository
import com.lalsoft.recyclerviewmvvmdatabinding.model.User

class RecyclerViewModel : ViewModel() {
    private val repository by lazy { Repository() }

    private val _adapter: MutableLiveData<RecyclerAdapter> = MutableLiveData()
    val adapter: LiveData<RecyclerAdapter>
        get() = _adapter
    private val _userList: MutableLiveData<ArrayList<*>> = MutableLiveData()
    val userList: LiveData<ArrayList<*>>
        get() = _userList


    init {
        _userList.value = repository.getUserList()
        _adapter.value=RecyclerAdapter()
    }

    fun setAdapter(users: ArrayList<User>) {
        _adapter.value!!.setUserList(users)
        _adapter.value!!.notifyDataSetChanged()

    }

}
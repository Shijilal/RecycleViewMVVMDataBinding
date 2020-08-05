package com.lalsoft.recyclerviewmvvmdatabinding.data

class Repository {
    private val userDao=UserDao()
    private var instance: Repository? = null

    fun getInstance(): Repository {
        if (instance == null) {
            instance = Repository()
        }
        return instance as Repository
    }

    fun getUserList()=userDao.getUserArray()
}
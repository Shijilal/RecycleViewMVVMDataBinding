package com.lalsoft.recycleviewmvvmdatabinding.data

import com.lalsoft.recycleviewmvvmdatabinding.model.User

class UserDao {
    fun getUserArray():ArrayList<User>{
        val userArrayList:ArrayList<User> = ArrayList()
        var user=User("Mohanlal","lalettan","Trivandrum","Kerala")
        userArrayList.add(user)
        user=User("Mammotty","Mamookka","Ernakulam","Kerala")
        userArrayList.add(user)
        user=User("Kunchako Boban","Chakochan","Kollam","Kerala")
        userArrayList.add(user)
        return userArrayList
    }
}
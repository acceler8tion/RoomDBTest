package com.seuiggi.roomdbtest

import android.app.Application
import androidx.lifecycle.LiveData

class UserRepository(application: Application) {

    private val userDatabase = UserDataBase.getInstance(application)!!
    private val userDao: UserDAO = userDatabase.userDao()
    private val users: LiveData<List<User>> = userDao.getAll()
    private val ids: LiveData<List<String>> = userDao.getIds()
    private val passwords: LiveData<List<String>> = userDao.getPasswords()

    fun getAll(): LiveData<List<User>> {
        return users
    }

    fun getIds(): LiveData<List<String>> {
        return ids
    }

    fun getPasswords(): LiveData<List<String>> {
        return passwords
    }

    fun insert(user: User) {
        userDao.insert(user)
    }

    fun delete(user: User) {
        userDao.delete(user)
    }

}
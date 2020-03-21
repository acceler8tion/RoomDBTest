package com.seuiggi.roomdbtest

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData

class UserViewModel(application: Application) : AndroidViewModel(application) {

    private val repository = UserRepository(application)
    private val ids = repository.getIds()
    private val passwords = repository.getPasswords()
    private val users = repository.getAll()

    fun getAll(): LiveData<List<User>> {
        return this.users
    }

    fun getIds(): LiveData<List<String>> {
        return this.ids
    }

    fun getPasswords(): LiveData<List<String>> {
        return this.passwords
    }

    fun insert(user: User) {
        repository.insert(user)
    }

    fun delete(user: User) {
        repository.delete(user)
    }
}
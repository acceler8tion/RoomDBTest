package com.seuiggi.roomdbtest

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface UserDAO {

    @Query("SELECT * FROM user")
    fun getAll(): LiveData<List<User>>

    @Query("SELECT id FROM user WHERE NOT id is NULL")
    fun getIds(): LiveData<List<String>>

    @Query("SELECT password FROM user WHERE NOT password is NULL")
    fun getPasswords(): LiveData<List<String>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(user: User)

    @Delete
    fun delete(user: User)
}
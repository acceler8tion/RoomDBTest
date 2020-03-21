package com.seuiggi.roomdbtest

import androidx.room.ColumnInfo
import androidx.room.Entity

@Entity(tableName = "user", primaryKeys = ["id", "password"])
data class User(
    @ColumnInfo(name = "hash")
    var hash : Long?,
    var id: String,
    var password: String
) {
    constructor() : this(null, "", "")
}
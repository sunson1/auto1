package com.example.auto.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class Work (
    @PrimaryKey val id : Int?
    ) {
    var name : String? = null
}

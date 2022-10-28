package com.example.auto.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.Relation

@Entity(tableName = "worklist")
data class WorkList (
    @PrimaryKey val id:Int?) {

    //@Relation(entity = Work::class, entityColumn = "id", parentColumn = "work_id")
    var work_id : Int? = null
    var mileage : Int? = null
    var price : Int? = null

}

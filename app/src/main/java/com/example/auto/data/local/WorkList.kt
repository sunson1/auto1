package com.example.auto.data.local

import androidx.room.Entity
import androidx.room.Relation

@Entity(tableName = "worklist")
data class WorkList (val id:Int?) {

    @Relation(entity = Work::class, entityColumn = "id", parentColumn = "work_id")
    val work_id : Int? = null
    val mileage : Int? = null
    val price : Int? = null

}

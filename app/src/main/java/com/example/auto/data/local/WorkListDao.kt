package com.example.auto.data.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query

@Dao
interface WorkListDao {

    @Query("SELECT * FROM worklist" +
            " join work on worklist.work_id = work.id")
    fun list(): LiveData<List<WorkRelation>>

}

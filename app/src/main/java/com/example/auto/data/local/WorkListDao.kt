package com.example.auto.data.local

import androidx.lifecycle.LiveData
import androidx.room.Query

interface WorkListDao {

    @Query("SELECT * FROM worklist")
    fun list(): LiveData<List<WorkList>>

}

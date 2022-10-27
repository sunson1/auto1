package com.example.auto.repository

import com.example.auto.data.local.WorkListDao
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class WorkListRepository @Inject constructor(private val workListDao : WorkListDao) {

    fun getWorkList() = workListDao.list()

}
package com.example.auto

import androidx.lifecycle.ViewModel
import com.example.auto.repository.WorkListRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AutoViewModel  @Inject constructor(
    private val workListRepository : WorkListRepository
) : ViewModel() {

    fun listWorks() = workListRepository.getWorkList()

}

package com.example.auto

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel

import androidx.navigation.NavHostController
import com.example.auto.data.local.WorkRelation


@Composable
fun ListWork(nav : NavHostController) {

    val viewModel : AutoViewModel = hiltViewModel()
    val list = viewModel.listWorks().observeAsState(emptyList())

    ListWork(list.value,nav)

}

@Composable
fun ListWork(value: List<WorkRelation>, nav : NavHostController) {
    LazyColumn() {
        items(value) {
            Text(it.workName.toString())
        }
    }
}

@Preview
@Composable
fun PreviewListWork() {
    val nav = NavHostController(LocalContext.current)
    ListWork(value = emptyList(),nav )
}


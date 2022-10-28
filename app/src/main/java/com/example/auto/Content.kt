package com.example.auto

import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.compose.compiler.plugins.kotlin.EmptyFunctionMetrics.composable
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.MutableLiveData
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument

@RequiresApi(Build.VERSION_CODES.N)
@Composable
fun Content() {

    val navController = rememberNavController()
    var showFab = remember { mutableStateOf (true)  }

    Log.d("ContentContent",showFab.value.toString())

    Scaffold(
        floatingActionButton = {

            if ( showFab.value!! )
                FloatingActionButton(onClick = {
                    navController.navigate(Screen.Edit().route)
                }) {
                    Icon(Icons.Filled.Add,"", Modifier.padding(10.dp), Color.Cyan)
                }
        },
        isFloatingActionButtonDocked = true,
        bottomBar = {
            BottomAppBar(
                // Defaults to null, that is, No cutout
                cutoutShape = MaterialTheme.shapes.small.copy(
                    CornerSize(percent = 50)
                )
            ) {
                /* Bottom app bar content */
            }
        }
    ) {

        it
        NavHost(navController = navController, startDestination = "list") {
            composable(Screen.List.route) { ListWork(navController); showFab.value = true }
            composable(Screen.Edit().route) {
                EditWork(null)
                Log.d("ContentContent","edit null")
                showFab.value = false
            }
            composable(Screen.Edit().route+"/{Id?}") { EditWork(navArgument("Id") {
                defaultValue = null
            })
            showFab.value = false
            }
        }


    }

}

sealed class Screen(val route : String ) {
    object List : Screen("list")
    class Edit() : Screen("edit")
}
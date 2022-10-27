package com.example.auto

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument

@Composable
fun Content() {

    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "list") {
        composable(Screen.List.route) { ListWork() }
        composable(Screen.Edit().route+"/{Id}") { EditWork(navArgument("Id") {
            defaultValue = null
        })}
    }
}

sealed class Screen(val route : String ) {
    object List : Screen("list")
    class Edit() : Screen("edit")
}
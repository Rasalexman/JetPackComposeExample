package com.usell.android.screens.menu.tasks

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.usell.android.screens.menu.main.ItemsLayout
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun Tasks(navController: NavController, viewModel: TasksViewModel = viewModel()) {
    //println("----> TasksViewModel hash = ${viewModel.hashCode()}")
    ItemsLayout(parentNavController = navController, viewModel = viewModel)
}
package com.usell.android.screens.menu.events

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.usell.android.screens.menu.main.ItemsLayout
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun Events(navController: NavController, viewModel: EventsViewModel = viewModel()) {
    //println("----> EventsViewModel hash = ${viewModel.hashCode()}")
    ItemsLayout(parentNavController = navController, viewModel = viewModel)
}
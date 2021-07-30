package com.usell.android.screens.details

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.usell.android.layouts.MyBackAppTopAppBar

@Composable
fun Details(navController: NavController, viewModel: DetailsViewModel = viewModel()) {
    val title: String by viewModel.title.observeAsState("")
    val desc: String by viewModel.description.observeAsState("")

    Column {
        MyBackAppTopAppBar(topAppBarText = title) {
            navController.popBackStack()
        }

        Text(
            text = desc,
            style = MaterialTheme.typography.subtitle1,
            modifier = Modifier
                .fillMaxWidth()
                .padding(PaddingValues(16.dp))
        )

    }
}
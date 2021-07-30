package com.usell.android.screens.menu.main

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.usell.android.layouts.MyAppTopAppBar
import com.usell.android.screens.base.BaseItemsViewModel
import com.usell.android.models.MainItemUI

@Composable
fun Main(parentNavController: NavController, viewModel: MainViewModel = viewModel()) {
    //println("----> MainViewModel hash = ${viewModel.hashCode()}")
    ItemsLayout(parentNavController = parentNavController, viewModel = viewModel)
}

@Composable
fun ItemsLayout(parentNavController: NavController, viewModel: BaseItemsViewModel) {
    Column {

        val title: Int by viewModel.title.collectAsState()
        MyAppTopAppBar(stringResource(id = title))

        val onItemClicked: (MainItemUI) -> Unit = { item ->
            viewModel.onItemClicked(item, parentNavController)
        }

        val items: List<MainItemUI> by viewModel.mainItems.collectAsState()

        val scrollState = rememberLazyListState()
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            state = scrollState
        ) {
            items(items) { item ->
                MainItem(item, onItemClicked)
            }
        }
    }
}

@Composable
fun MainItem(item: MainItemUI, onItemClick: (MainItemUI) -> Unit) {
    Column(
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxWidth()
            .clickable(
                interactionSource = remember { MutableInteractionSource() },
                indication = rememberRipple(bounded = true), // You can also change the color and radius of the ripple
                onClick = {
                    onItemClick(item)
                }
            )
    ) {
        Text(
            text = item.title,
            style = MaterialTheme.typography.subtitle1,
            modifier = Modifier.padding(end = 16.dp, start = 16.dp, top = 8.dp)
        )
        Text(
            text = item.description,
            style = MaterialTheme.typography.subtitle1,
            modifier = Modifier.padding(bottom = 8.dp, end = 16.dp, start = 16.dp),
        )
        Divider(modifier = Modifier.fillMaxWidth(), color = Color.Gray, thickness = 1.dp)
    }
}
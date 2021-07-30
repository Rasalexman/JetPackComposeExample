package com.usell.android.navigation

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.List
import androidx.compose.ui.graphics.vector.ImageVector
import com.usell.android.R

sealed class Screens(val route: String, @StringRes val resourceId: Int) {
    object Login : Screens(ScreenNames.LOGIN, R.string.title_login)
    object Menu : Screens(ScreenNames.MENU, R.string.title_bottom)
    object Details : Screens(ScreenNames.DETAILS, R.string.title_bottom)

    sealed class BottomMenu(val iconVector: ImageVector, route: String, resourceId: Int) : Screens(route, resourceId) {
        object Main : BottomMenu(Icons.Filled.Favorite, ScreenNames.BottomMenu.MAIN, R.string.title_main)
        object Tasks : BottomMenu(Icons.Filled.Call, ScreenNames.BottomMenu.TASKS, R.string.title_tasks)
        object Events : BottomMenu(Icons.Filled.List, ScreenNames.BottomMenu.EVENTS, R.string.title_events)
    }

    companion object {
        val bottomItems: List<BottomMenu>
            get() = listOf(BottomMenu.Main, BottomMenu.Tasks, BottomMenu.Events)
    }

}

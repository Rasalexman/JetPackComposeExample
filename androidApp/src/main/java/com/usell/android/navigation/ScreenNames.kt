package com.usell.android.navigation

object ScreenNames {
    const val LOGIN: String = "LoginScreen"
    const val MENU: String = "MenuScreen"
    const val DETAILS: String = "DetailsScreen/{${ScreenArgs.ITEM_TITLE}}/{${ScreenArgs.ITEM_DESC}}"

    fun detailsWithArgs(title: String, desc: String): String {
        return "DetailsScreen/$title/$desc"
    }


    object BottomMenu {
        const val MAIN: String = "MainScreen"
        const val EVENTS: String = "EventsScreen"
        const val TASKS: String = "TasksScreen"
    }
}
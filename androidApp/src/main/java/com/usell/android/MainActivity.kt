package com.usell.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.usell.Greeting
import com.usell.android.models.MainItemUI
import com.usell.android.navigation.ScreenArgs
import com.usell.android.navigation.ScreenNames
import com.usell.android.navigation.Screens
import com.usell.android.screens.details.Details
import com.usell.android.screens.menu.Menu
import com.usell.android.screens.login.Login
import com.usell.android.theme.USellTheme

fun greet(): String {
    return Greeting().greeting()
}

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainActivityView()
        }
    }
}

@Composable
private fun MainActivityView() {
    USellTheme {
        // A surface container using the 'background' color from the theme
        Surface(color = MaterialTheme.colors.background) {
            val navController = rememberNavController()
            NavHost(navController = navController, startDestination = ScreenNames.LOGIN) {
                composable(ScreenNames.LOGIN) { Login(navController = navController) }
                composable(ScreenNames.MENU) { Menu(parentNavController = navController, items = Screens.bottomItems) }

                composable(
                    route = ScreenNames.DETAILS,
                    arguments = listOf(
                        navArgument(ScreenArgs.ITEM_TITLE) { type = NavType.StringType },
                        navArgument(ScreenArgs.ITEM_DESC) { type = NavType.StringType }
                    )
                ) {
                    Details(navController)
                }
            }
        }
    }
}

@Preview
@Composable
private fun MainActivityViewPreview() {
    MainActivityView()
}

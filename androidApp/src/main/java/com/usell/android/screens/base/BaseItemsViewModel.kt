package com.usell.android.screens.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import com.usell.android.navigation.ScreenNames
import com.usell.android.domain.GetMainItemsUseCase
import com.usell.android.domain.IGetMainItemsUseCase
import com.usell.android.models.MainItemUI
import kotlinx.coroutines.flow.*

abstract class BaseItemsViewModel : ViewModel() {

    abstract val titleResId: Int

    private val getMainItemsUseCase: IGetMainItemsUseCase = GetMainItemsUseCase()
    private val _title by lazy {
        MutableStateFlow(titleResId)
    }
    val title: StateFlow<Int> = _title

    private val _mainItems: Flow<List<MainItemUI>> by lazy {
        getMainItemsUseCase.invoke()
    }
    val mainItems: StateFlow<List<MainItemUI>> = _mainItems.stateIn(viewModelScope, SharingStarted.Lazily, emptyList())

    open fun onItemClicked(item: MainItemUI, navController: NavController) {
        println("-----> Item pos = ${item.position}")
        navController.navigate(ScreenNames.detailsWithArgs(title = item.title, desc = item.description))
    }
}


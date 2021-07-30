package com.usell.android.screens.details

import androidx.lifecycle.LiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.usell.android.navigation.ScreenArgs

class DetailsViewModel(
    savedStateHandle: SavedStateHandle
) : ViewModel() {
        val title: LiveData<String> = savedStateHandle.getLiveData(ScreenArgs.ITEM_TITLE)
        val description: LiveData<String> = savedStateHandle.getLiveData(ScreenArgs.ITEM_DESC)
}
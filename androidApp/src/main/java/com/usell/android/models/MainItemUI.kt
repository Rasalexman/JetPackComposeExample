package com.usell.android.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class MainItemUI(
    val position: Int,
    val title: String,
    val description: String
) : Parcelable

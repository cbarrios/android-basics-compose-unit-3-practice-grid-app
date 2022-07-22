package com.lalosapps.gridapp.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Topic(
    @StringRes val nameResource: Int,
    val totalCourses: Int,
    @DrawableRes val imageResource: Int
)

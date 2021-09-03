package com.example.instagramuicompose.data

import androidx.annotation.DrawableRes

/**
 * Created by Dhruv Limbachiya on 03-09-2021.
 */

data class StoryHighlight(
    @DrawableRes val imageRes: Int,
    val highlightName: String
)

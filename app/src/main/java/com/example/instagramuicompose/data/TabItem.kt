package com.example.instagramuicompose.data

import androidx.compose.ui.graphics.painter.Painter

/**
 * Created by Dhruv Limbachiya on 05-09-2021.
 */

data class TabItem(
    val tabIcon: Painter,
    val contentDescription: String? = null
)

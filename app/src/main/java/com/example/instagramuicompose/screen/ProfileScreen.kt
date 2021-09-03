package com.example.instagramuicompose.screen

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.instagramuicompose.R

/**
 * Created by Dhruv Limbachiya on 03-09-2021.
 */

@Composable
fun ProfileScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        // Top App Bar
        TopAppBar(
            modifier = Modifier.padding(12.dp),
            instagramHandleName = "dhruv__limbachiya"
        )
        Spacer(modifier = Modifier.height(4.dp))
        ProfileSection()
    }
}

@Composable
fun TopAppBar(
    modifier: Modifier = Modifier,
    instagramHandleName: String
) {
    Row(
        modifier = modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = Icons.Default.ArrowBack,
            contentDescription = "Back Arrow",
            tint = Color.Black,
            modifier = Modifier.size(30.dp)
        )

        Text(
            text = instagramHandleName,
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold,
            overflow = TextOverflow.Ellipsis // Show Ellipsis(...) when instagramHandleName is too long.
        )

        Icon(
            painter = painterResource(id = R.drawable.ic_bell),
            contentDescription = "Notifications",
            tint = Color.Black,
            modifier = Modifier.size(24.dp)
        )

        Icon(
            painter = painterResource(id = R.drawable.ic_dotmenu),
            contentDescription = "Dot Menu",
            tint = Color.Black,
            modifier = Modifier.size(20.dp)
        )
    }
}

/**
 * Composable for displaying profile section data like profile image,statistics & bio.
 */
@Composable
fun ProfileSection(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp, vertical = 16.dp),
    ) {
        Row(
            modifier = modifier
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            RoundImage(imageResourceId = R.drawable.img_2, modifier = Modifier.weight(3f))
            Spacer(modifier = Modifier.width(10.dp))
            StatisticsSection(modifier = Modifier.weight(7f))
        }
    }
}

/**
 * Composable for displaying RoundImage for profile image & highlights.
 */
@Composable
fun RoundImage(
    modifier: Modifier = Modifier,
    @DrawableRes imageResourceId: Int
) {
    Image(
        painter = painterResource(id = imageResourceId),
        contentDescription = null,
        contentScale = ContentScale.FillBounds,
        modifier = modifier
            // matchHeightConstraintsFirst = true :  Calculate the height value of the image and make width with equal of height value.
            .aspectRatio(1f, matchHeightConstraintsFirst = true)
            .border(
                width = 1.dp,
                color = Color.LightGray,
                shape = CircleShape
            )
            .padding(4.dp)
            .clip(CircleShape)

    )
}

/**
 * Composable for displaying user statistics like posts,follower & following.
 */
@Composable
fun StatisticsSection(
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceAround
    ) {
        ProfileStatistics(number = "162", textToDisplay = "Posts")
        ProfileStatistics(number = "459", textToDisplay = "Followers")
        ProfileStatistics(number = "408", textToDisplay = "Following")
    }
}

/**
 * Re-usable composable for displaying profile statistics.
 */
@Composable
fun ProfileStatistics(
    modifier: Modifier = Modifier,
    number: String,
    textToDisplay: String
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = number,
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp
        )
        
        Spacer(modifier = Modifier.height(4.dp))

        Text(
            text = textToDisplay,
            fontSize = 16.sp
        )
    }
}
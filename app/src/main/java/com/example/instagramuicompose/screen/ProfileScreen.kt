package com.example.instagramuicompose.screen

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
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
        ProfileDescription(
            displayName = "Dhruv Limbachiya",
            description = "Sagittarius \uD83D\uDC7B\n" +
                    "Android App Developer \uD83D\uDC69\u200D\uD83D\uDCBB\n" +
                    "Modern Monk \uD83D\uDC7C\n" +
                    "Fitness Enthusiat \uD83D\uDCAA",
            url = "https://github.com/DHRUV-LIMBACHIYA",
            followedBy = listOf("danbilzerian", "katrinakaif"),
            otherCount = 54
        )
        Spacer(modifier = Modifier.height(20.dp))
        ButtonSection(modifier = Modifier.fillMaxWidth())
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
            .padding(horizontal = 20.dp, vertical = 10.dp),
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
        modifier = modifier,
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically
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


/**
 * Composable for user bio.
 */
@Composable
fun ProfileDescription(
    displayName: String,
    description: String,
    url: String,
    followedBy: List<String>,
    otherCount: Int
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp)
    ) {
        val letterSpacing = 0.5.sp  // The amount of space to add between each letter
        val lineHeight = 20.sp // Line height for the Paragraph

        Text(
            text = displayName,
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp,
            letterSpacing = letterSpacing,
            lineHeight = lineHeight
        )

        Text(
            text = description,
            lineHeight = lineHeight
        )

        Text(
            text = url,
            color = Color(0xFF3D3D91),
            letterSpacing = letterSpacing,
            lineHeight = lineHeight
        )

        if (followedBy.isNotEmpty()) {
            // Style for followed person name text and others text
            val boldStyle = SpanStyle(
                color = Color.Black,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = buildAnnotatedString {
                    append("Followed by ")
                    followedBy.forEachIndexed { index, name ->
                        pushStyle(boldStyle) // Push the bold style in the stack. Followed text will have this pushed style.
                        append(name)
                        pop() // Pop the current bold style.
                        // Append "," after name if it is not the last element in the list.
                        if (index < followedBy.size - 1) {
                            append(", ")
                        }
                    }
                    append(" and ")
                    pushStyle(boldStyle) // Push the bold style again.
                    append("$otherCount others")
                }
            )
        }
    }
}

/**
 * Composable for displaying all action buttons.
 */
@Composable
fun ButtonSection(
    modifier: Modifier = Modifier
) {
    val minWidth = 100.dp
    val height = 35.dp
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.SpaceEvenly,
    ) {
        ActionButton(
            buttonText = "Following",
            icon = Icons.Default.KeyboardArrowDown,
            modifier = Modifier
                .defaultMinSize(minWidth = minWidth)
                .height(height)
        )
        ActionButton(
            buttonText = "Message", modifier = Modifier
                .defaultMinSize(minWidth = minWidth)
                .height(height)
        )
        ActionButton(
            buttonText = "Email", modifier = Modifier
                .defaultMinSize(minWidth = minWidth)
                .height(height)
        )
        ActionButton(
            icon = Icons.Default.KeyboardArrowDown, modifier = Modifier.height(height)
        )
    }
}

@Composable
fun ActionButton(
    modifier: Modifier = Modifier,
    buttonText: String? = null,
    icon: ImageVector? = null
) {
    Row(
        modifier = modifier
            .border(
                width = 1.dp,
                color = Color.LightGray,
                shape = RoundedCornerShape(6.dp)
            )
            .padding(6.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        buttonText?.let {
            Text(
                text = buttonText,
                fontWeight = FontWeight.SemiBold,
                overflow = TextOverflow.Ellipsis,
            )
        }

        icon?.let {
            Icon(
                imageVector = icon,
                contentDescription = null,
                tint = Color.Black,
                modifier = Modifier.size(24.dp)
            )
        }
    }
}
package com.example.articlepage

import android.graphics.drawable.Drawable
import android.graphics.drawable.Icon
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.graphics.toColorInt
import com.example.myapplication.utils.Utilities
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.HorizontalPagerIndicator
import com.google.accompanist.pager.rememberPagerState


@OptIn(ExperimentalPagerApi::class)
@Composable
fun Sample() {

    Column(
        Modifier
            .fillMaxWidth()
            .background(Utilities.backColor)
    ) {
        val pagerState = rememberPagerState()
        LaunchedEffect(pagerState) {
            snapshotFlow { pagerState.currentPage }.collect { page ->
                val isScroll = pagerState.isScrollInProgress
            }
        }
        Spacer(modifier = Modifier.height(10.dp))
        HorizontalPager(
            count = 7,
            state = pagerState,
            modifier = Modifier
                .fillMaxWidth(),
            ) {
            FullCard()
        }
        Spacer(modifier = Modifier.height(15.dp))

        HorizontalPagerIndicator(
            pagerState = pagerState,
            modifier = Modifier
                .align(Alignment.CenterHorizontally),
            activeColor = Utilities.activeColor,
            indicatorShape = CircleShape,
            indicatorWidth = 6.dp,
            indicatorHeight = 6.dp,
            spacing = 10.dp,
            inactiveColor = Utilities.inactiveColor
        )
        Spacer(modifier = Modifier.height(25.dp))

    }
}

@Composable
fun FullCard() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 10.dp)
    ) {
        GamePreviewImage1(R.drawable.livegame)
    }
}


@Composable
fun GamePreviewImage1(gameImage: Int) {

    Column(

    ) {
        Image(
            painter = painterResource(id = gameImage),
            contentDescription = "Game Preview Image",
            contentScale = ContentScale.FillBounds,
            modifier = Modifier
                .fillMaxWidth()
                .height(250.dp)
                .clip(
                    RoundedCornerShape(5.dp)
                )
        )
        Spacer(modifier = Modifier.height(10.dp))
        Text(
            text = "Image caption title goes here on one line lorem ipsum dolor sit amet",
            color = Color.White.copy(0.5f),
            textAlign = TextAlign.Center,
            style = TextStyle(
                fontSize = 12.sp,
                fontWeight = FontWeight.W300,
                fontFamily = Utilities.opensansitalic
            ),
            modifier = Modifier.fillMaxWidth()
        )

    }

}

@Composable
fun TextDetail(
) {
    Column(
        Modifier
            .wrapContentSize()
            .padding(8.dp)
    ) {
        Spacer(modifier = Modifier.height(15.dp))
        Title(text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit")
        Spacer(modifier = Modifier.height(17.dp))
        SubTitle(text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna")
        Spacer(modifier = Modifier.height(17.dp))
        AuthorText(text = "by Author Name")
        Spacer(modifier = Modifier.height(15.dp))
        SquareBoxes()


    }

}

@Composable
fun Title(text: String) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
    ) {
        Text(
            text = text,
            style = TextStyle(
                fontSize = 18.sp,
                fontFamily = FontFamily.Serif,
                fontWeight = FontWeight.W900
            )
        )
    }
}


@Composable
fun SubTitle(text: String) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
    ) {
        Text(
            text = text,
            style = TextStyle(
                fontSize = 14.sp,
                fontWeight = FontWeight.W700,
                fontFamily = Utilities.opensansbold,
            )
        )
    }
}


@Composable
fun AuthorText(text: String) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
    ) {
        Text(
            text = text,
            style = TextStyle(
                fontSize = 14.sp,
                fontWeight = FontWeight.W400,
                fontFamily = Utilities.opensansregular,
            )
        )
    }
}

@Composable
fun SquareBoxes() {
    LazyRow(
        Modifier
            .fillMaxWidth()
            .wrapContentHeight(),
    ) {
        items(4) {
            Icon_Ui(iconImage = Icons.Default.Person)
        }
    }

}

@Composable
fun Icon_Ui(iconImage: ImageVector) {
    Card(
        Modifier
            .size(40.dp),
        shape = RoundedCornerShape(4.dp),
        backgroundColor = Utilities.iconBackColor,
    ) {
        androidx.compose.material.Icon(
            imageVector = iconImage,
            contentDescription = "icon",
            modifier = Modifier.padding(10.dp),
            tint = Color.White
        )
    }
    Spacer(modifier = Modifier.width(10.dp))
}

@Preview
@Composable
fun Preview() {
    Sample()
}
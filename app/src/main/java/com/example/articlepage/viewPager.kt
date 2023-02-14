package com.example.articlepage

import android.icu.text.ListFormatter.Width
import android.view.RoundedCorner
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CornerBasedShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
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
import java.time.format.TextStyle


@OptIn(ExperimentalPagerApi::class)
@Composable
fun Sample() {

    Column(
        Modifier
            .fillMaxWidth()
            .background(Utilities.innerColor)
            .padding(bottom = 15.dp)
    ) {
        val pagerState = rememberPagerState()
        HorizontalPager(
            count = 7,
            state = pagerState,
            modifier = Modifier
                .fillMaxWidth(),
        ) {
            Full1()
        }
        HorizontalPagerIndicator(
            pagerState = pagerState,
            modifier = Modifier
                .align(Alignment.CenterHorizontally),
            activeColor = Utilities.activeColor,
            inactiveColor = Utilities.inactiveColor
        )

    }
}

@Composable
fun FullCard() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Utilities.backColor)
    ) {
        GamePreviewImage1()
    }
}


@Composable
fun GamePreviewImage1() {

    val imageRes = painterResource(id = R.drawable.livegame)
    val color = "#0d2148"
    Color(color.toColorInt())

    Column(
        modifier = Modifier
            .background(Utilities.innerColor)

    ) {
        Image(
            painter = imageRes,
            contentDescription = "Game Preview Image",
            contentScale = ContentScale.FillBounds,
            modifier = Modifier
                .fillMaxWidth()
                .height(221.dp)
                .clip(
                    RoundedCornerShape(
                        topEnd = Utilities.cornerRadius,
                        topStart = Utilities.cornerRadius
                    )
                )
        )
        Column(
            Modifier
                .fillMaxWidth()
                .padding(4.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "jndjdnjjnjndjdn",
                color = Color.White,
                textAlign = TextAlign.Justify,
                style = androidx.compose.ui.text.TextStyle(
                    fontSize = 10.sp, fontWeight = FontWeight.Light
                )
            )
        }
    }

}


@Composable
fun Full1() {
    Box(
        modifier = Modifier
            .background(Utilities.innerColor)
            .padding(8.dp),
        contentAlignment = Alignment.Center
    ) {
        Column(modifier = Modifier.background(Utilities.backColor)) {
            FullCard()
        }
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
        BoldText(text = "Lorem ipsum hbdbdh")
        Spacer(modifier = Modifier.height(8.dp))
        SmallText(text = "hbdhdbhbdjbjhbjdbjhbdjhbdjhbdjbdjhbdj jh dibjdb")
        Spacer(modifier = Modifier.height(8.dp))
        AuthorText(text = "by Author Name")
        Spacer(modifier = Modifier.height(8.dp))
        SquareBoxes()


    }

}

@Composable
fun BoldText(text: String) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
    ) {
        Text(
            text = text,
            style = androidx.compose.ui.text.TextStyle(
                fontSize = 26.sp,
                fontFamily = FontFamily.SansSerif,
                fontWeight = FontWeight.ExtraBold
            )
        )
    }
}


@Composable
fun SmallText(text: String) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
    ) {
        Text(
            text = text,
            style = androidx.compose.ui.text.TextStyle(
                fontSize = 14.sp,
                fontWeight = FontWeight.SemiBold,
                fontFamily = FontFamily.SansSerif,
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
            style = androidx.compose.ui.text.TextStyle(
                fontSize = 12.sp,
                fontWeight = FontWeight.Light,
                fontFamily = FontFamily.SansSerif,
            )
        )
    }
}

@Composable
fun webView(){

}

@Composable
fun SquareBoxes() {
    Row(
        Modifier
            .fillMaxWidth()
            .wrapContentHeight(),
    ) {
        Card(
            Modifier
                .height(40.dp)
                .width(40.dp),
            elevation = 4.dp,
            backgroundColor = Color.Blue,
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_launcher_foreground),
                contentDescription = null,
                contentScale = ContentScale.Crop
            )
        }
        Spacer(modifier = Modifier.width(8.dp))
        Card(
            Modifier
                .height(40.dp)
                .width(40.dp),
            shape = RoundedCornerShape(5.dp),
            elevation = 4.dp,
            backgroundColor = Color.Blue,
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_launcher_foreground),
                contentDescription = null,
                contentScale = ContentScale.Crop

            )
        }
        Spacer(modifier = Modifier.width(8.dp))
        Card(
            Modifier
                .height(40.dp)
                .width(40.dp),
            shape = RoundedCornerShape(5.dp),
            elevation = 4.dp,
            backgroundColor = Color.Blue,
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_launcher_foreground),
                contentDescription = null,
                contentScale = ContentScale.Crop

            )
        }
        Spacer(modifier = Modifier.width(8.dp))
        Card(
            Modifier
                .height(40.dp)
                .width(40.dp),
            shape = RoundedCornerShape(5.dp),
            elevation = 4.dp,
            backgroundColor = Color.Blue,
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_launcher_foreground),
                contentDescription = null,
                contentScale = ContentScale.Crop
            )
        }
    }

}

@Preview
@Composable
fun Preview() {
    Sample()
}
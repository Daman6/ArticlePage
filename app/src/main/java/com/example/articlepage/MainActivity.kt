package com.example.articlepage

import android.annotation.SuppressLint
import android.content.res.Configuration
import android.graphics.Bitmap
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.WindowInsetsController
import android.view.WindowManager
import android.webkit.WebView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.view.WindowCompat
import com.example.articlepage.ui.theme.ArticlePageTheme
import com.google.accompanist.web.*

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArticlePageTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {

                    Column(
                        Modifier
                            .fillMaxSize()
                            .background(Color.White)
                    ) {
                        Sample()
                        TextDetail()
                        Webview()
                    }
                }
            }
        }
    }
}


val baseURL = "https://widgets.media.sportradar.com/"
val content =
    "<!DOCTYPE HTML>\n" +
            "<html>\n" +
            "    <head>\n" +
            "        <meta name=\"viewport\" content=\"width=device-width,initial-scale=1\">\n" +
            "            <script>\n" +
            "                (function(a,b,c,d,e,f,g,h,i){a[e]||(i=a[e]=function(){(a[e].q=a[e].q||[]).push(arguments)},i.l=1*new Date,i.o=f,\n" +
            "                g=b.createElement(c),h=b.getElementsByTagName(c)[0],g.async=1,g.src=d,g.setAttribute(\"n\",e),h.parentNode.insertBefore(g,h)\n" +
            "                )})(window,document,\"script\",\"https://widgets.media.sportradar.com/viewlift/widgetloader\",\"SIR\", {\n" +
            "                    language: 'en_us'\n" +
            "                });\n" +
            "                SIR('addWidget', '#sr-widget', 'us.common.scoreTicker', {sport: \"nba\", onItemClick: function(target, obj){alert(target+':'+JSON.stringify(obj));}});\n" +
            "            </script>\n" +
            "            <div id=\"sr-widget\"></div>\n" +
            "    </head>\n" +
            "    <body>\n" +
            "        <div id=\"sr-widget\"></div>\n" +
            "    </body>\n" +
            "</html>"

@Composable
fun Webview() {


    val webData: WebContent.Data = WebContent.Data(content, baseURL)

    MainScreen(webData)


}


@SuppressLint("SetJavaScriptEnabled")
@Composable
fun WebViewFun(
    modifier: Modifier = Modifier
) {
    val state = rememberWebViewState(url = "https://stevdza-san.com")

    val loadingState = state.loadingState
    if (loadingState is LoadingState.Loading) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            CircularProgressIndicator(
                progress = loadingState.progress,
                modifier = Modifier
                    .height(50.dp)
                    .width(50.dp)
            )
        }

    }

    val webClient = remember {
        object : AccompanistWebViewClient() {
            override fun onPageStarted(
                view: WebView?,
                url: String?,
                favicon: Bitmap?
            ) {
                super.onPageStarted(view, url, favicon)
                Log.d("Accompanist WebView", "Page started loading for $url")
            }
        }
    }


    WebView(
        state = state,
        modifier = modifier.fillMaxSize(),
        onCreated = { webView ->
            webView.settings.javaScriptEnabled = true
        },
        client = webClient

    )
}

fun getListOfWebviews(): MutableList<WebviewPojo> {
    val list: MutableList<WebviewPojo> = mutableListOf()

    for (i in 0 until 10) {
        list.add(WebviewPojo())
    }

    return list
}

class WebviewPojo()

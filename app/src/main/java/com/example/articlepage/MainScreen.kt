package com.example.articlepage

import android.graphics.Bitmap
import android.util.Log
import android.view.View
import android.webkit.WebResourceRequest
import android.webkit.WebSettings
import android.webkit.WebView
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.google.accompanist.web.*
import timber.log.Timber

val progress: MutableState<Boolean> = mutableStateOf(true)

@Composable
fun MainScreen(webData: WebContent.Data) {
//    val state: WebViewState = rememberWebViewState(url = "https://staging-mse.viewlift.com/scoreUpdateWidget")

    Box {
        val state = WebViewState(webData)
        ShowWebView(state)
        ShowProgressbar(progress = progress)
    }
}

@Composable
private fun getWebViewClient(): AccompanistWebViewClient {
    val webClient: AccompanistWebViewClient = remember {
        object : AccompanistWebViewClient() {
            override fun onPageStarted(
                view: WebView?,
                url: String?,
                favicon: Bitmap?
            ) {
                progress.value = true
                super.onPageStarted(view, url, favicon)
                Log.d("Accompanist WebView", "Page started loading for $url")
            }

            override fun onPageFinished(view: WebView?, url: String?) {
                super.onPageFinished(view, url)
                progress.value = false

                Log.d("Accompanist WebView", "Page finished loading for $url")
            }

            override fun shouldOverrideUrlLoading(
                view: WebView?,
                request: WebResourceRequest?
            ): Boolean {
                return false
            }
        }
    }
    return webClient
}

@Composable
private fun ShowWebView(
    state: WebViewState
) {
    val webClient: AccompanistWebViewClient = getWebViewClient()

    Column(
        modifier = Modifier
            .height(140.dp)
            .fillMaxWidth()
    ) {
        Log.d("Accompanist WebView", "webview recomposed")
        WebView(
            modifier = Modifier.height(130.dp),
            state = state,
            onCreated = { webView ->
                webView.settings.javaScriptEnabled = true
                webView.setLayerType(View.LAYER_TYPE_SOFTWARE, null)
//            webView.settings.cacheMode = WebSettings.LOAD_NO_CACHE
                webView.settings.cacheMode = WebSettings.LOAD_DEFAULT
                webView.settings.domStorageEnabled = true
            },
            client = webClient
        )
    }
}

@Composable
fun ShowProgressbar(progress: MutableState<Boolean>) {
    if (progress.value) {
        Box( modifier = Modifier
            .height(140.dp)
            .fillMaxWidth()){
            Box(
                modifier = Modifier
                    .align(Alignment.Center)
                    .background(Color.White)
            ) {
                Log.d("Accompanist WebView", "CircularProgressIndicator recomposed")

                CircularProgressIndicator(
                    modifier = Modifier
                        .padding(8.dp)
                        .height(30.dp),
                    color = Color.Black,
                    strokeWidth = 2.dp
                )
            }
        }
    } else {
        Log.d("Accompanist WebView", "CircularProgressIndicator removed")
    }
}



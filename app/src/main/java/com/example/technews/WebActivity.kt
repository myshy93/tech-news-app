package com.example.technews

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_web.*


class WebActivity : AppCompatActivity() {

    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web)

        val url = intent.getStringExtra(ArticlesAdapter.articleIdKey)
        webView.settings.javaScriptEnabled = true
        webView.webViewClient = MyAppWebViewClient()
        Log.d("WEBVIEW", url)
        WebView.setWebContentsDebuggingEnabled(false)
        webView.loadUrl(url)
        Log.d("WEBVIEW", "Connected")
    }

    inner class MyAppWebViewClient : WebViewClient() {

        override fun shouldOverrideUrlLoading(view: WebView, url: String): Boolean {
            return false
        }
    }
}

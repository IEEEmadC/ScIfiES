package com.example.prasad.appnavi;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class Activity2 extends AppCompatActivity {
    private WebView mWebview;
    private String e1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

       Intent intent=getIntent();
       e1=intent.getStringExtra("e");



        mWebview=(WebView) findViewById(R.id.webSites); //loading web sites
        WebSettings webSettings=mWebview.getSettings();
        mWebview.setWebViewClient(new WebViewClient());
        mWebview.getSettings().setDomStorageEnabled(true);
        mWebview.setOverScrollMode(WebView.OVER_SCROLL_NEVER);
        webSettings.setJavaScriptEnabled(true);
        mWebview.loadUrl(e1);
    }

    @Override
    protected void onPause(){
        super.onPause();
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
    }
    @Override
    protected void onResume(){
        super.onResume();
    }
    @Override
    public void onBackPressed(){
        super.onBackPressed();
    }
}


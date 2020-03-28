package com.example.firstproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends AppCompatActivity {
    private WebView mywebView = (WebView)findViewById(R.id.nyWeb);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        WebSettings webSettings = mywebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        mywebView.loadUrl("https://tengrinews.kz");
        mywebView.setWebViewClient(new WebViewClient());

    }

    public void onBackPressed(){
        if(mywebView.canGoBack()){
            mywebView.goBack();
        }
        else {
            super.onBackPressed();
        }
    }
}

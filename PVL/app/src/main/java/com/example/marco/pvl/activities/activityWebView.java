package com.example.marco.pvl.activities;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.webkit.WebView;

import com.example.marco.pvl.R;

public class activityWebView extends AppCompatActivity {


    WebView wv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        wv = findViewById(R.id.webView);

        wv.getSettings().setJavaScriptEnabled(true);
        wv.loadUrl("http://www.magicmgmt.com/gary/magic8ball/index1.html");
        wv.goForward();
    }

}

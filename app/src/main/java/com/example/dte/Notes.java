package com.example.dte;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class Notes extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes);
        WebView webView = findViewById(R.id.notesWeb);
        setTitle("Notes");
        getActionBar();
        webView.loadUrl("https://drive.google.com/folderview?id=1-E2Cv23hG1mYzDHlELYmmgqPHSRxHsJW");

        webView.getSettings().setJavaScriptEnabled(true);

        webView.setWebViewClient(new WebViewClient());
    }
}
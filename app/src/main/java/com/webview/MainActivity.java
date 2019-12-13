package com.webview;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static WebView myWebView;
    private static ProgressBar progress;
    private static TextView sTextView;
    private static ImageView sImageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myWebView = findViewById(R.id.WebView);
        progress = findViewById(R.id.progressbar);
        progress.setMax(100);
        sTextView = findViewById(R.id.textView);
        sImageView = findViewById(R.id.imageView);
        myWebView.setWebViewClient(new WebViewClient());
        String url = getIntent().getStringExtra("SearchEngine");
        myWebView.loadUrl(url);
        myWebView.getSettings().setJavaScriptEnabled(true);
        myWebView.setWebChromeClient(new WebChromeClient(){
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                super.onProgressChanged(view, newProgress);
                progress.setProgress(newProgress);

            }

            @Override
            public void onReceivedTitle(WebView view, String title) {
                super.onReceivedTitle(view, title);
                sTextView.setText(title);
            }

            @Override
            public void onReceivedIcon(WebView view, Bitmap icon) {
                super.onReceivedIcon(view, icon);
                sImageView.setImageBitmap(icon);
            }
        });
    }



    @Override
    public void onBackPressed() {
        if(myWebView.canGoBack()){
            myWebView.goBack();
        }else
        {

            finish();
        }
    }
}


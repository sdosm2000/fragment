package com.example.innu.bankdemo;

import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;


public class SBIFragment extends Fragment {
    public SBIFragment() {
    }
WebView webView;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_sbi,container,false);
      webView=(WebView)view.findViewById(R.id.web_sbi);
        final ProgressDialog dialog= new ProgressDialog(getActivity());
        webView.setWebViewClient(new WebViewClient()
        {
            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
            dialog.setMessage("please wait..........");
                dialog.show();
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                dialog.dismiss();
            }
        });
        webView.loadUrl("https://retail.onlinesbi.com/retail/login.htm");
        WebSettings webSettings=webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        return view;
    }
}

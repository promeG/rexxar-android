package com.douban.rexxar.example;

import com.douban.rexxar.example.widget.menu.MenuItem;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by luanqian on 16/9/26.
 */
public class WebviewClientActivity extends AppCompatActivity {

    public static final String TAG = WebviewClientActivity.class.getSimpleName();

    public static void startActivity(Activity activity, String uri) {
        Intent intent = new Intent(activity, WebviewClientActivity.class);
        intent.setData(Uri.parse(uri));
        activity.startActivity(intent);
    }

    @InjectView(R.id.webView)
    WebView mRexxarWebView;

    private List<MenuItem> mMenuItems = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.webviewclient_activity);
        ButterKnife.inject(this);

        // load uri
        mRexxarWebView.setWebChromeClient(new WebChromeClient());
        mRexxarWebView.setWebViewClient(new WebViewClient());
        mRexxarWebView.getSettings().setJavaScriptEnabled(true);

        mRexxarWebView.loadUrl("http://47.88.87.43/detail.html?id=1");
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        for (MenuItem menuItem : mMenuItems) {
            menuItem.getMenuView(menu, this);
        }
        return super.onCreateOptionsMenu(menu);
    }

}

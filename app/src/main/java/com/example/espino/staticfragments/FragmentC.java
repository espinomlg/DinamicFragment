package com.example.espino.staticfragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Xml;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

/**
 * Created by espino on 28/11/16.
 */

public class FragmentC extends Fragment {

    private WebView webview;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View rootView = inflater.inflate(R.layout.fragment_c, container, false);
        webview = (WebView) rootView.findViewById(R.id.webview);
        webview.loadData(getResources().getString(R.string.html), "text/html", Xml.Encoding.UTF_8.toString());
        return rootView;
    }
}

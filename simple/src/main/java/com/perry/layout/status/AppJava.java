package com.perry.layout.status;

import android.app.Application;

import com.perry.layout.library.Config;
import com.perry.layout.library.LayoutStatusManage;

public class AppJava extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        LayoutStatusManage.Companion.setConfig(new Config()
                .setEmptyLayout(R.layout.layout_empty, R.id.ll_empty)
                .setErrorLayout(R.layout.layout_error, R.id.ll_error)
                .setLoadingLayout(R.layout.layout_loading));
    }
}

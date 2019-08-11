package com.perry.layout.status;

import android.app.Application;
import com.perry.layout.library.Config;

import java.lang.reflect.Array;


public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        new Config().setEmptyLayout(R.layout.layout_empty);
    }
}

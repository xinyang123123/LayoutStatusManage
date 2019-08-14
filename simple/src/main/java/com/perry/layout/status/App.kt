package com.perry.layout.status

import android.app.Application
import com.perry.layout.library.Config
import com.perry.layout.library.LayoutStatusManage

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        LayoutStatusManage.config = Config().apply {
//            setEmptyLayout(R.layout.layout_empty)
//            setErrorLayout(R.layout.layout_error)
//            setLoadingLayout(R.layout.layout_loading)
        }
    }
}
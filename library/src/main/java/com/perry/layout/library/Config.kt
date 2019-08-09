package com.perry.layout.library

import android.view.View
import androidx.annotation.IdRes
import androidx.annotation.LayoutRes

class Config {

    @LayoutRes
    var emptyLayoutId: Int = R.layout.layout_loading

    @IdRes
    var emptyClickId: Int? = null

    @LayoutRes
    var errorLayoutId: Int = R.layout.layout_loading

    @IdRes
    var errorClickId: Int? = null

    @LayoutRes
    var loadingLayoutId: Int = R.layout.layout_loading
}
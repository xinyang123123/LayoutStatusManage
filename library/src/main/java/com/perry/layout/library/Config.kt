package com.perry.layout.library

import androidx.annotation.IdRes
import androidx.annotation.LayoutRes

class Config {

    @LayoutRes
    var emptyLayoutId: Int = R.layout.layout_default_empty
        private set

    @IdRes
    var emptyClickId: Int? = R.id.ll_empty
        private set

    @LayoutRes
    var errorLayoutId: Int = R.layout.layout_default_error
        private set

    @IdRes
    var errorClickId: Int? = R.id.ll_error
        private set

    @LayoutRes
    var loadingLayoutId: Int = R.layout.layout_default_loading
        private set

    fun setEmptyLayout(@LayoutRes layoutId: Int, @IdRes clickId: Int? = null): Config {
        emptyLayoutId = layoutId
        emptyClickId = clickId
        return this@Config
    }

    fun setErrorLayout(@LayoutRes layoutId: Int, @IdRes clickId: Int? = null): Config {
        errorLayoutId = layoutId
        errorClickId = clickId
        return this@Config
    }

    fun setLoadingLayout(@LayoutRes layoutId: Int): Config {
        loadingLayoutId = layoutId
        return this@Config
    }
}
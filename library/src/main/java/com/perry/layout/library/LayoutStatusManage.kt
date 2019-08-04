package com.perry.layout.library

import android.view.LayoutInflater
import android.view.View
import androidx.annotation.IdRes
import androidx.annotation.LayoutRes

class LayoutStatusManage(builder: Builder) {

    private var contentLayout: View

    private var inflater: LayoutInflater

    private var emptyLayout: View?
        get() = if (field == null) inflate(emptyLayoutId) else field

    @LayoutRes
    private var emptyLayoutId: Int
    @IdRes
    private var emptyClickId: Int? = null

    private var errorLayout: View? = null
    @LayoutRes
    private var errorLayoutId: Int = R.layout.layout_loading
    @IdRes
    private var errorClickId: Int? = null

    private var loadingLayout: View? = null
        get() = if (field == null) inflate(loadingLayoutId) else field

    @LayoutRes
    var loadingLayoutId: Int = R.layout.layout_loading


    init {
        contentLayout = builder.contentLayout
        inflater = LayoutInflater.from(contentLayout.context)

        emptyLayout = builder.emptyLayout
        emptyLayoutId = builder.emptyLayoutId

        emptyClickId = builder.emptyClickId

        errorLayout = builder.errorLayout
        errorLayoutId = builder.errorLayoutId
        errorClickId = builder.errorClickId

        loadingLayout = builder.loadingLayout
        loadingLayoutId = builder.loadingLayoutId
    }

    private fun inflate(@LayoutRes layoutIdRes: Int): View {
        inflater = LayoutInflater.from(contentLayout.context)

        return inflater.inflate(layoutIdRes, null)
    }

    fun showContentLayout() {

    }

    fun showEmptyLayout() {

    }

    fun showErrorLayout() {

    }

    fun showLoadingLayout() {

    }

    fun showCustomizeLayout(layout: View, vararg clickViewIds: Int? = emptyArray()) {

    }

    class Builder(val contentLayout: View) {

        var emptyLayout: View? = null
        @LayoutRes
        var emptyLayoutId: Int = R.layout.layout_loading
        @IdRes
        var emptyClickId: Int? = null

        var errorLayout: View? = null
        @LayoutRes
        var errorLayoutId: Int = R.layout.layout_loading
        @IdRes
        var errorClickId: Int? = null

        var loadingLayout: View? = null
        @LayoutRes
        var loadingLayoutId: Int = R.layout.layout_loading

        fun build() : LayoutStatusManage = LayoutStatusManage(this)
    }
}
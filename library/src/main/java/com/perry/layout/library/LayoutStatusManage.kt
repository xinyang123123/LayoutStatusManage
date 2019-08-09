package com.perry.layout.library

import android.view.LayoutInflater
import android.view.View
import androidx.annotation.IdRes
import androidx.annotation.LayoutRes

class LayoutStatusManage(private val contentLayout: View) {

    companion object {
        var config: Config? = null
    }

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
        contentLayout = config.contentLayout
        inflater = LayoutInflater.from(contentLayout.context)

        emptyLayout = config.emptyLayout
        emptyLayoutId = config.emptyLayoutId

        emptyClickId = config.emptyClickId

        errorLayout = config.errorLayout
        errorLayoutId = config.errorLayoutId
        errorClickId = config.errorClickId

        loadingLayout = config.loadingLayout
        loadingLayoutId = config.loadingLayoutId
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


}
package com.perry.layout.library

import android.view.LayoutInflater
import android.view.View
import androidx.annotation.IdRes
import androidx.annotation.LayoutRes

class LayoutStatusManage(private val contentLayout: View) {

    companion object {
        lateinit var config: Config
    }

    private var emptyLayout: View

    @LayoutRes
    private var emptyLayoutId: Int

    @IdRes
    private var emptyClickId: Int?

    private var errorLayout: View

    @LayoutRes
    private var errorLayoutId: Int

    @IdRes
    private var errorClickId: Int?

    private var loadingLayout: View

    @LayoutRes
    var loadingLayoutId: Int

    init {
        emptyLayoutId = config.emptyLayoutId
        emptyClickId = config.emptyClickId
        emptyLayout = inflate(emptyLayoutId)

        errorLayoutId = config.errorLayoutId
        errorClickId = config.errorClickId
        errorLayout = inflate(errorLayoutId)

        loadingLayoutId = config.loadingLayoutId
        loadingLayout = inflate(loadingLayoutId)
    }

    private fun inflate(@LayoutRes layoutIdRes: Int): View =
            LayoutInflater.from(contentLayout.context).inflate(layoutIdRes, null)

    fun setEmptyLayout(@LayoutRes layoutId: Int, @IdRes  clickIds: Int? = null): LayoutStatusManage {
        emptyLayoutId = layoutId
        emptyClickId = clickIds
        emptyLayout = inflate(emptyLayoutId)
        return this@LayoutStatusManage
    }

    fun setErrorLayout(@LayoutRes layoutId: Int, @IdRes  clickId: Int? = null): LayoutStatusManage {
        errorLayoutId = layoutId
        errorClickId = clickId
        errorLayout = inflate(errorLayoutId)
        return this@LayoutStatusManage
    }

    fun setLoadingLayout(@LayoutRes layoutId: Int): LayoutStatusManage {
        loadingLayoutId = layoutId
        loadingLayout = inflate(loadingLayoutId)
        return this@LayoutStatusManage
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

    fun setClickListener() {

    }

}
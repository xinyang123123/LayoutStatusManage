package com.perry.layout.library

import android.view.LayoutInflater
import android.view.View
import androidx.annotation.IdRes
import androidx.annotation.LayoutRes

class LayoutStatusManage(private val contentLayout: View) {

    companion object {
        lateinit var config: Config
    }

    var emptyLayout: View
        private set

    var errorLayout: View
        private set

    var loadingLayout: View
        private set

    var onClickListener: StatusLayoutClickListener? = null

    @LayoutRes
    private var emptyLayoutId: Int

    @IdRes
    private var emptyClickId: Int?

    @LayoutRes
    private var errorLayoutId: Int

    @IdRes
    private var errorClickId: Int?

    @LayoutRes
    private var loadingLayoutId: Int

    private var helper: SwitchLayoutHelper

    init {
        emptyLayoutId = config.emptyLayoutId
        emptyClickId = config.emptyClickId
        emptyLayout = inflate(emptyLayoutId)

        errorLayoutId = config.errorLayoutId
        errorClickId = config.errorClickId
        errorLayout = inflate(errorLayoutId)

        loadingLayoutId = config.loadingLayoutId
        loadingLayout = inflate(loadingLayoutId)

        setEmptyClickEvent()
        setErrorClickEvent()

        helper = SwitchLayoutHelper(contentLayout)
    }

    private fun inflate(@LayoutRes layoutIdRes: Int): View =
        LayoutInflater.from(contentLayout.context).inflate(layoutIdRes, null)

    private fun setEmptyClickEvent() {
        emptyClickId?.let {
            emptyLayout.findViewById<View>(it)?.setOnClickListener { view -> onClickListener?.emptyClick(view) }
        }
    }

    private fun setErrorClickEvent() {
        errorClickId?.let {
            errorLayout.findViewById<View>(it).setOnClickListener { view -> onClickListener?.errorClick(view) }
        }
    }

    fun setEmptyLayout(@LayoutRes layoutId: Int, @IdRes clickIds: Int? = null): LayoutStatusManage {
        emptyLayoutId = layoutId
        emptyClickId = clickIds
        emptyLayout = inflate(emptyLayoutId)
        setEmptyClickEvent()
        return this@LayoutStatusManage
    }

    fun setErrorLayout(@LayoutRes layoutId: Int, @IdRes clickId: Int? = null): LayoutStatusManage {
        errorLayoutId = layoutId
        errorClickId = clickId
        errorLayout = inflate(errorLayoutId)
        setErrorClickEvent()
        return this@LayoutStatusManage
    }

    fun setLoadingLayout(@LayoutRes layoutId: Int): LayoutStatusManage {
        loadingLayoutId = layoutId
        loadingLayout = inflate(loadingLayoutId)
        return this@LayoutStatusManage
    }

    fun showContentLayout() {
        helper.switchLayout(contentLayout)
    }

    fun showEmptyLayout() {
        helper.switchLayout(emptyLayout)
    }

    fun showErrorLayout() {
        helper.switchLayout(errorLayout)
    }

    fun showLoadingLayout() {
        helper.switchLayout(loadingLayout)
    }

    fun showCustomizeLayout(layout: View, vararg clickViewIds: Int? = emptyArray()) {

    }

    fun showCustomizeLayout(@LayoutRes layoutId: Int, vararg clickViewIds: Int? = emptyArray()) {

    }
}
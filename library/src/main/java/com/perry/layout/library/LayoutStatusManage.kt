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
        helper.showView(contentLayout)
    }

    fun showEmptyLayout() {
        helper.showView(emptyLayout)
    }

    fun showErrorLayout() {
        helper.showView(errorLayout)
    }

    fun showLoadingLayout() {
        helper.showView(loadingLayout)
    }

    fun showCustomizeLayout(view: View, vararg clickViewIds: Int? = emptyArray()) {
        setCustomizeClickEvent(view, *clickViewIds)
        helper.showView(view)
    }

    fun showCustomizeLayout(@LayoutRes layoutId: Int, vararg clickViewIds: Int? = emptyArray()) {
        inflate(layoutId).let {
            setCustomizeClickEvent(it, *clickViewIds)
            helper.showView(it)
        }
    }

    fun <T : View> findContentChildView(@IdRes viewId: Int): T? = contentLayout.findViewById(viewId)

    fun <T : View> findErrorChildView(@IdRes viewId: Int): T? = errorLayout.findViewById(viewId)

    fun <T : View> findEmptyChildView(@IdRes viewId: Int): T? = emptyLayout.findViewById(viewId)

    fun <T : View> findLoadingChildView(@IdRes viewId: Int): T? = loadingLayout.findViewById(viewId)

    private fun setCustomizeClickEvent(view: View, vararg clickViewIds: Int?) {
        clickViewIds.forEach {
            it?.let {
                view.findViewById<View>(it)
                    ?.setOnClickListener { view -> onClickListener?.customizeClick(view) }
            }
        }
    }

    private fun setEmptyClickEvent() {
        emptyClickId?.let {
            emptyLayout.findViewById<View>(it)
                ?.setOnClickListener { view -> onClickListener?.emptyClick(view) }
        }
    }

    private fun setErrorClickEvent() {
        errorClickId?.let {
            errorLayout.findViewById<View>(it)
                ?.setOnClickListener { view -> onClickListener?.errorClick(view) }
        }
    }
}
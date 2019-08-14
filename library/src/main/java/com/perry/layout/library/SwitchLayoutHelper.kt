package com.perry.layout.library

import android.view.View
import android.view.ViewGroup

class SwitchLayoutHelper(private val contentLayout: View) {

    private var parent = contentLayout.parent as ViewGroup
    private var layoutParams: ViewGroup.LayoutParams = contentLayout.layoutParams
    private var currentShowView: View = contentLayout

    fun showView(view: View) {
        view.layoutParams = layoutParams
        view.id = contentLayout.id

        val indexOfChild = parent.indexOfChild(currentShowView)
        parent.removeView(currentShowView)
        parent.addView(view, indexOfChild)
        currentShowView = view
    }
}
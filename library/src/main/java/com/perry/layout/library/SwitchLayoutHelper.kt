package com.perry.layout.library

import android.view.View
import android.view.ViewGroup

class SwitchLayoutHelper(private val contentLayout: View) {

    private var parent = contentLayout.parent as ViewGroup
    private var layoutParams: ViewGroup.LayoutParams = contentLayout.layoutParams
    private var currentShowView: View = contentLayout

    fun switchLayout(view: View) {
        view.layoutParams = layoutParams
        view.id = contentLayout.id

        var indexOfChild = parent.indexOfChild(currentShowView)
        parent.removeView(currentShowView)
        parent.addView(view, indexOfChild)
        currentShowView = view
    }
}
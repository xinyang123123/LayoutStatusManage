# LayoutStatusManage

[![API](https://img.shields.io/badge/API-19%2B-brightgreen.svg?style=flat)](https://android-arsenal.com/api?level=19)

Used for Android layout state switching, success, failure, loading, empty data, etc.

## Description

Written in Kotlin, you can configure any state layout without increasing the layout nesting level.

Idea reference [StatusLayoutManager](https://github.com/Bakumon/StatusLayoutManager), increase support for RelativeLayout compared to it.


## Adding to project
  
    // project/build.gradle
    allprojects {
        repositories {
            ...
            maven { url 'https://jitpack.io' }
        }
    }

    // module/build.gradle
    dependencies {
        implementation 'com.perry:layoutStatusManage:1.0.0'
    }

## Simple usage

1. Init on `Application`
    ```
    // kotlin
    LayoutStatusManage.config = Config().apply {
        setEmptyLayout(R.layout.layout_empty, R.id.ll_empty)
        setErrorLayout(R.layout.layout_error, R.id.ll_error)
        setLoadingLayout(R.layout.layout_loading)
    }

    // java
    LayoutStatusManage.Companion.setConfig(new Config()
        .setEmptyLayout(R.layout.layout_empty, R.id.ll_empty)
        .setErrorLayout(R.layout.layout_error, R.id.ll_error)
        .setLoadingLayout(R.layout.layout_loading))
    ```

2. Switch layout
   ```
    var layoutStatusManage : LayoutStatusManage = LayoutStatusManage(tv)

    layoutStatusManage.showContentLayout()
    layoutStatusManage.showErrorLayout()
    layoutStatusManage.showEmptyLayout()
    layoutStatusManage.showLoadingLayout()

    layoutStatusManage.showCustomizeLayout(
                    R.layout.layout_customize,
                    R.id.btn_1,
                    R.id.btn_2,
                    R.id.btn_3
                )
   ```
3. Click listener
   ```
   // kotlin
   layoutStatusManage.onClickListener = object : StatusLayoutClickListener {
                override fun emptyClick(view: View?) {
                    this@MainActivity.toast("empty")
                }

                override fun errorClick(view: View?) {
                    this@MainActivity.toast("error")
                }

                override fun customizeClick(view: View?) {
                    when (view?.id) {
                        R.id.btn_1 -> {
                            this@MainActivity.toast("1")
                        }
                        R.id.btn_2 -> {
                            this@MainActivity.toast("2")
                        }
                        R.id.btn_3 -> {
                            this@MainActivity.toast("3")
                        }
                        else -> {
                        }
                    }
                }
            }
   ```
4. Other Api
   ```
    // set status layout and click view id
    layoutStatusManage.setEmptyLayout(R.layout.layout_empty, R.id.ll_empty)
    layoutStatusManage.setErrorLayout(R.layout.layout_empty, R.id.ll_empty)
    layoutStatusManage.setLoadingLayout(R.layout.layout_empty)
   
    // get layout child view by id
    layoutStatusManage.findContentChildView(R.id.xx)
    layoutStatusManage.findErrorChildView(R.id.xx)
    layoutStatusManage.findEmptyChildView(R.id.xx)
    layoutStatusManage.findLoadingChildView(R.id.xx)

    // get status view 
    layoutStatusManage.getErrorLayout()
    layoutStatusManage.getEmptyLayout()
    layoutStatusManage.getLoadingLayout()
   ```
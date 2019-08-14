package com.perry.layout.status

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import com.perry.layout.library.LayoutStatusManage
import com.perry.layout.library.StatusLayoutClickListener
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.toast

class MainActivity : AppCompatActivity() {

    private lateinit var layoutStatusManage: LayoutStatusManage

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initLayoutStatus()
    }

    private fun initLayoutStatus() {
        layoutStatusManage = LayoutStatusManage(tv).apply {
            onClickListener = object : StatusLayoutClickListener {
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
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.home_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item?.itemId) {
            R.id.menu_item_content -> {
                layoutStatusManage.showContentLayout()
            }
            R.id.menu_item_error -> {
                layoutStatusManage.showErrorLayout()
            }
            R.id.menu_item_empty -> {
                layoutStatusManage.showEmptyLayout()
            }
            R.id.menu_item_loading -> {
                layoutStatusManage.showLoadingLayout()
            }
            R.id.menu_item_customize -> {
                layoutStatusManage.showCustomizeLayout(
                    R.layout.layout_customize,
                    R.id.btn_1,
                    R.id.btn_2,
                    R.id.btn_3
                )
            }
            else -> {
            }
        }
        return super.onOptionsItemSelected(item)
    }
}

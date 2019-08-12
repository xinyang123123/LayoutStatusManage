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
                    Toast.makeText(this@MainActivity, "empty", Toast.LENGTH_SHORT).show()
                }

                override fun errorClick(view: View?) {
                    Toast.makeText(this@MainActivity, "error", Toast.LENGTH_SHORT).show()
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
            else -> {
            }
        }
        return super.onOptionsItemSelected(item)
    }
}

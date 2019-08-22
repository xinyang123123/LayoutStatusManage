package com.perry.layout.status;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.perry.layout.library.LayoutStatusManage;
import com.perry.layout.library.StatusLayoutClickListener;

public class JavaActivity extends AppCompatActivity {

    private LayoutStatusManage layoutStatusManage;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_java);

        initLayoutStatus();
    }

    private void initLayoutStatus() {
        TextView textView = findViewById(R.id.tv);
        layoutStatusManage = new LayoutStatusManage(textView);
        layoutStatusManage.setOnClickListener(new StatusLayoutClickListener() {
            @Override
            public void customizeClick(@org.jetbrains.annotations.Nullable View view) {
                assert view != null;
                switch (view.getId()) {
                    case R.id.btn_1:
                        Toast.makeText(JavaActivity.this, "1", Toast.LENGTH_LONG).show();
                        break;
                    case R.id.btn_2:
                        Toast.makeText(JavaActivity.this, "2", Toast.LENGTH_LONG).show();
                        break;
                    case R.id.btn_3:
                        Toast.makeText(JavaActivity.this, "3", Toast.LENGTH_LONG).show();
                        break;
                    default:
                        break;
                }
            }

            @Override
            public void emptyClick(@org.jetbrains.annotations.Nullable View view) {
                Toast.makeText(JavaActivity.this, "error", Toast.LENGTH_LONG).show();
            }

            @Override
            public void errorClick(@org.jetbrains.annotations.Nullable View view) {
                Toast.makeText(JavaActivity.this, "error", Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.home_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_item_content:
                layoutStatusManage.showContentLayout();
                break;
            case R.id.menu_item_error:
                layoutStatusManage.showErrorLayout();
                break;
            case R.id.menu_item_empty:
                layoutStatusManage.showEmptyLayout();
                break;
            case R.id.menu_item_loading:
                layoutStatusManage.showLoadingLayout();
                break;
            case R.id.menu_item_customize:
                layoutStatusManage.showCustomizeLayout(R.layout.layout_customize, R.id.btn_1, R.id.btn_2, R.id.btn_3);
                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}

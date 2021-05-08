package com.elaine.testviewmodel;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

public class MainActivity extends AppCompatActivity {
    //使用viewModel
    private MainViewModel mainViewModel;
    private TextView tvContent;
    //不使用viewModel
    private int contentTwo;
    private TextView tvContentTwo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        testViewModel();
        noViewModel();
    }

    /**
     * 使用到ViewModel的变量
     */
    private void testViewModel() {
        mainViewModel = new ViewModelProvider(this, new ViewModelProvider.AndroidViewModelFactory(getApplication())).get(MainViewModel.class);
        tvContent = findViewById(R.id.tv_content);
        tvContent.setText(mainViewModel.content + "");
    }

    /**
     * 常规变量
     */
    private void noViewModel() {
        tvContentTwo = findViewById(R.id.tv_content_two);
        contentTwo = 0;
        tvContentTwo.setText(contentTwo + "");
    }

    /**
     * 数字增大方法
     *
     * @param view
     */
    public void add(View view) {
        tvContent.setText(++mainViewModel.content + "");
        tvContentTwo.setText(++contentTwo + "");
    }
}
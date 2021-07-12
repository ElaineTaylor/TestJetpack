package com.elaine.testroom;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.elaine.testroom.databinding.ActivityMainBinding;
import com.elaine.testroom.db.music.MusicBean;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding mBinding;
    private MainViewModel model;
    private MusicAdapter musicAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        initViewModel();
        initAdapter();
    }

    /**
     * 初始化viewModel
     */
    private void initViewModel() {
        model = new ViewModelProvider(this, new ViewModelProvider.AndroidViewModelFactory(getApplication())).get(MainViewModel.class);
        //列表进行更改数据
        model.getAll().observe(this, musicBeans -> {
            if (musicBeans != null) {
                musicAdapter.setList(musicBeans);
            }
        });
    }

    /**
     * 初始化适配器
     */
    private void initAdapter() {
        musicAdapter = new MusicAdapter();
        mBinding.rvMusic.setLayoutManager(new LinearLayoutManager(this));
        mBinding.rvMusic.setAdapter(musicAdapter);

        //子控件点击事件
        musicAdapter.addChildClickViewIds(R.id.btn_delete, R.id.btn_update);
        musicAdapter.setOnItemChildClickListener((adapter, view, position) -> {
            MusicBean musicBean = musicAdapter.getData().get(position);
            if (musicBean != null) {
                if (view.getId() == R.id.btn_delete) {//删除操作
                    model.delete(musicBean);
                } else if (view.getId() == R.id.btn_update) {//更新操作
                    musicBean.setSinger("歌手改" + (int) (Math.random() * 10));
                    model.update(musicBean);
                }
            }
        });
    }

    /**
     * 新增按钮点击事件
     */
    public void insert(View view) {
        MusicBean musicBean = new MusicBean("歌曲名称" + (int) (Math.random() * 10), (int) (Math.random() * 10), "评论", "歌手" + (int) (Math.random() * 10), !(Math.random() > 0.5));
        model.insert(musicBean);
    }
}
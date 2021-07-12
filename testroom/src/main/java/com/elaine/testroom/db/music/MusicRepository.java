package com.elaine.testroom.db.music;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.elaine.testroom.db.CommonDatabase;

import java.util.List;

/**
 * 数据库异步处理
 * author: elaine
 * date: 2021/7/12
 */
public class MusicRepository {
    private MusicDao musicDao;

    public MusicRepository(Context context) {
        musicDao = CommonDatabase.getInstance(context).getMusicDao();
    }

    /**
     * 插入数据
     * 异步执行
     *
     * @param musicBeans 实体
     */
    @SuppressLint("StaticFieldLeak")
    public void insert(MusicBean... musicBeans) {
        new AsyncTask<MusicBean, Void, Void>() {

            @Override
            protected Void doInBackground(MusicBean... musicBeans) {
                musicDao.insert(musicBeans);
                return null;
            }
        }.execute(musicBeans);
    }

    /**
     * 更新
     * 异步执行
     *
     * @param musicBeans 实体
     */
    @SuppressLint("StaticFieldLeak")
    public void update(MusicBean... musicBeans) {
        new AsyncTask<MusicBean, Void, Void>() {

            @Override
            protected Void doInBackground(MusicBean... musicBeans) {
                musicDao.update(musicBeans);
                return null;
            }
        }.execute(musicBeans);
    }

    /**
     * 删除
     * 异步执行
     *
     * @param musicBeans 实体
     */
    @SuppressLint("StaticFieldLeak")
    public void delete(MusicBean... musicBeans) {
        new AsyncTask<MusicBean, Void, Void>() {

            @Override
            protected Void doInBackground(MusicBean... musicBeans) {
                musicDao.delete(musicBeans);
                return null;
            }
        }.execute(musicBeans);
    }

    /**
     * 获取全部数据
     * 结合LiveData，方便数据及时更新
     *
     * @return List<MusicBean>
     */
    public LiveData<List<MusicBean>> getAll() {
        return musicDao.getAll();
    }

}

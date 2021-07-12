package com.elaine.testroom;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.elaine.testroom.db.music.MusicBean;
import com.elaine.testroom.db.music.MusicRepository;

import java.util.List;

/**
 * author: elaine
 * date: 2021/7/12
 */
public class MainViewModel extends AndroidViewModel {
    private MusicRepository musicRepository;

    public MainViewModel(@NonNull Application application) {
        super(application);
        musicRepository = new MusicRepository(application);
    }

    /**
     * 插入数据
     *
     * @param musicBeans 实体
     */
    public void insert(MusicBean... musicBeans) {
        musicRepository.insert(musicBeans);
    }

    /**
     * 更新
     *
     * @param musicBeans 实体
     */
    public void update(MusicBean... musicBeans) {
        musicRepository.update(musicBeans);
    }

    /**
     * 删除
     *
     * @param musicBeans 实体
     */
    public void delete(MusicBean... musicBeans) {
        musicRepository.delete(musicBeans);
    }

    /**
     * 获取全部数据
     *
     * @return List<MusicBean>
     */
    public LiveData<List<MusicBean>> getAll() {
        return musicRepository.getAll();
    }
}

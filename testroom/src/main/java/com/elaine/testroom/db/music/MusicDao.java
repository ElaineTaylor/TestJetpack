package com.elaine.testroom.db.music;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

/**
 * 音乐表Dao
 * author: elaine
 * date: 2021/7/9
 */
@Dao
public interface MusicDao {
    /**
     * 插入数据
     *
     * @param musicBeans 实体
     */
    @Insert
    void insert(MusicBean... musicBeans);

    /**
     * 更新
     *
     * @param musicBeans 实体
     */
    @Update
    void update(MusicBean... musicBeans);

    /**
     * 删除
     *
     * @param musicBeans 实体
     */
    @Delete
    void delete(MusicBean... musicBeans);

    /**
     * 获取全部数据
     *
     * @return List<MusicBean>
     */
    @Query("SELECT * FROM elaine_music")
    LiveData<List<MusicBean>> getAll();
}

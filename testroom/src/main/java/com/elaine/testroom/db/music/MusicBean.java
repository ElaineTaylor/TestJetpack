package com.elaine.testroom.db.music;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

/**
 * 音乐实体
 * author: elaine
 * date: 2021/7/9
 * <p>
 * Entity -----标记实体
 * tableName = "elaine_music" -----表名
 */
@Entity(tableName = "elaine_music")
public class MusicBean {
    /**
     * 自增长ID，主键
     * PrimaryKey ---主键
     * autoGenerate = true ---自增长
     */
    @PrimaryKey(autoGenerate = true)
    private Long id;
    /**
     * 歌曲名称
     */
    private String name;
    /**
     * mp3文件大小
     */
    private int size;
    /**
     * 评论
     */
    private String comment;
    /**
     * 歌手
     */
    private String singer;
    /**
     * 是否收藏了
     * ColumnInfo -----列信息
     * name = "is_save" -----重命名列名
     * typeAffinity = ColumnInfo.INTEGER -----存储类型
     */
    @ColumnInfo(name = "is_save", typeAffinity = ColumnInfo.INTEGER)
    private boolean isSave;

    /**
     * 是否在播放中
     * Ignore -----忽略，即不写入数据库
     */
    @Ignore
    private boolean isPlay;

    /**
     * 构造方法
     */
    public MusicBean(String name, int size, String comment, String singer, boolean isSave) {
        this.name = name;
        this.size = size;
        this.comment = comment;
        this.singer = singer;
        this.isSave = isSave;
    }

    /**
     * 构造方法
     * Ignore -----忽略，即不写入数据库
     */
    @Ignore
    public MusicBean(String name, int size, String comment, String singer) {
        this.name = name;
        this.size = size;
        this.comment = comment;
        this.singer = singer;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public boolean isSave() {
        return isSave;
    }

    public void setSave(boolean save) {
        isSave = save;
    }

    public boolean isPlay() {
        return isPlay;
    }

    public void setPlay(boolean play) {
        isPlay = play;
    }
}

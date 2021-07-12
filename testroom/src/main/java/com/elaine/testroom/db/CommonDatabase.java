package com.elaine.testroom.db;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.elaine.testroom.db.music.MusicBean;
import com.elaine.testroom.db.music.MusicDao;

/**
 * author: elaine
 * date: 2021/7/12
 * <p>
 * entities = MusicBean.class -----对象
 * version = 1 -----当前数据库版本号
 * exportSchema = true  -----是否生成json数据库升级日志文件
 */
@Database(entities = MusicBean.class, version = 1, exportSchema = true)
public abstract class CommonDatabase extends RoomDatabase {
    //数据库名字
    private static final String DATABASE_NAME = "elaine_room";
    //mInstance
    public static CommonDatabase mInstance;

    //单例
    public static CommonDatabase getInstance(Context context) {
        if (mInstance == null) {
            synchronized (CommonDatabase.class) {
                mInstance = Room.databaseBuilder(context.getApplicationContext(), CommonDatabase.class, DATABASE_NAME)
//                            .addMigrations(AppDataBase.MIGRATION_1_2) //若升级则加入这行代码
                        .build();
            }
        }
        return mInstance;
    }

    //若需要升级则添加以下代码。数据库变动添加Migration，简白的而说就是版本1到版本2改了什么东西,
    public static final Migration MIGRATION_1_2 = new Migration(1, 2) {
        @Override
        public void migrate(SupportSQLiteDatabase database) {
            database.execSQL("CREATE TABLE `elaine_search_history` (`history` TEXT NOT NULL , `id` LONG PRIMARY KEY AUTOINCREMENT NOT NULL)");
        }
    };

    /**
     * 获取Dao
     *
     * @return MusicDao
     */
    public abstract MusicDao getMusicDao();
}

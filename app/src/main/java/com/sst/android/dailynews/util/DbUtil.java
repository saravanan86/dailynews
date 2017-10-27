package com.sst.android.dailynews.util;

import android.arch.persistence.room.Room;
import android.content.Context;

import com.sst.android.dailynews.data.db.database.Database;

/**
 * Created by kathires on 10/22/17.
 */

public class DbUtil {
    public static Database getAppDb(Context context){
        Database db = Room.databaseBuilder(context, Database.class, "ArticleDb").build();
        return db;
    }
}

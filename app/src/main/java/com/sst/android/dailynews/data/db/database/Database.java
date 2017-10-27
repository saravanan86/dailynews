package com.sst.android.dailynews.data.db.database;

import android.arch.persistence.room.RoomDatabase;

import com.sst.android.dailynews.data.db.dao.ArticleDao;
import com.sst.android.dailynews.data.db.dao.NewsDao;
import com.sst.android.dailynews.data.model.Article;
import com.sst.android.dailynews.data.model.News;

/**
 * Created by kathires on 10/22/17.
 */

@android.arch.persistence.room.Database(entities = {
        Article.class, News.class}, version = 1)
public abstract class Database extends RoomDatabase {
    public abstract ArticleDao articleDao();
    public abstract NewsDao newsDao();
}

package com.sst.android.dailynews.data.db.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.sst.android.dailynews.data.model.Article;

import java.util.List;

/**
 * Created by kathires on 10/22/17.
 */
@Dao
public interface ArticleDao {

    @Delete
    public void deleteArticle(Article article);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public void addArticle(Article article);

    @Insert void addArticles(Article... articles);

    @Query("select * from article")
    public List<Article> getArticles();

}

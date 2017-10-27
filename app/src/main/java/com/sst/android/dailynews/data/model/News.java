package com.sst.android.dailynews.data.model;

import android.arch.persistence.room.Embedded;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import java.util.List;

/**
 * Created by kathires on 10/17/17.
 */
@Entity
public class News {

    private String status;
    @PrimaryKey
    @NonNull
    private String source;
    private String sortBy;
    @Embedded
    private Article article;
    public List<Article> articles;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getSortBy() {
        return sortBy;
    }

    public void setSortBy(String sortBy) {
        this.sortBy = sortBy;
    }

    /*public List<Article> getArtilces() {
        return articles;
    }

    public void setArtilces(List<Article> articles) {
        this.articles = articles;
    }*/
    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }
}

package com.sst.android.dailynews.data.model;

import android.graphics.drawable.BitmapDrawable;

/**
 * Created by kathires on 10/20/17.
 */

public class ListItem {

    private Article article;
    private BitmapDrawable bitmapDrawable;

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }

    public BitmapDrawable getBitmapDrawable() {
        return bitmapDrawable;
    }

    public void setBitmapDrawable(BitmapDrawable bitmapDrawable) {
        this.bitmapDrawable = bitmapDrawable;
    }

}

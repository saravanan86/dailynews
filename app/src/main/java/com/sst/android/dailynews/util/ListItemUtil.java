package com.sst.android.dailynews.util;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.util.Log;

import com.facebook.litho.ComponentContext;
import com.squareup.picasso.Picasso;
import com.sst.android.dailynews.data.model.Article;
import com.sst.android.dailynews.data.model.ListItem;
import com.sst.android.dailynews.data.model.News;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.PublishSubject;

/**
 * Created by kathires on 10/20/17.
 */

public class ListItemUtil {

    public static List<ListItem> createNewsArticleLists(final ComponentContext context, PublishSubject<List<ListItem>> listPublishSubject, List<Article> articleList){

        List<ListItem> listItems = new ArrayList<ListItem>();
        if (articleList!=null && articleList.size() > 0) {

            articleList.forEach(article -> {
                ListItem listItem = new ListItem();
                listItem.setArticle(article);
                listItem.setBitmapDrawable(getBitmap(context,article.getUrlToImage()));
                listItems.add(listItem);
            });
            listPublishSubject.onNext(listItems);

        } else {

            Observable<News> newsObservable = HttpUtil.getNewsService().getNewsObservable();
            newsObservable.subscribeOn(Schedulers.io())
                    //.observeOn(AndroidSchedulers.)
                    .subscribe(news -> {
                                int len = news.getArtilces().size();
                                for (int i=0; i<len; i++) {
                                    ListItem listItem = new ListItem();
                                    listItem.setArticle(news.getArtilces().get(i));
                                    listItem.setBitmapDrawable(getBitmap(context,news.getArtilces().get(i).getUrlToImage()));
                                    listItems.add(listItem);
                                }
                                Log.d("ListItemUtil", "Inside onNext!!!! and total item count is "+listItems.size()+"===="+listItems.get(listItems.size()-1).getBitmapDrawable().toString());
                            },
                            throwable -> {
                                Log.d("ListItemUtil", "Inside onError!!!!"+throwable.getMessage());
                            },
                            ()->{
                                listPublishSubject.onNext(listItems);
                                Log.d("ListItemUtil", "Inside onCompleted!!!!");
                            });

        }

        return listItems;

    }

    private static BitmapDrawable getBitmap (ComponentContext context, String imageUrl) {


        try {

            Bitmap bitmap = Picasso.with(context).load(imageUrl).resize(2000,2000).onlyScaleDown().get();
            return new BitmapDrawable(null, bitmap);

        } catch (Exception ioException){
            Log.e("ListItemUtil", ioException.getMessage());
            return null;
        }

    }

}

package com.sst.android.dailynews;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.OrientationHelper;
import android.util.Log;

import com.facebook.litho.Component;
import com.facebook.litho.ComponentContext;
import com.facebook.litho.LithoView;
import com.facebook.litho.widget.ComponentRenderInfo;
import com.facebook.litho.widget.LinearLayoutInfo;
import com.facebook.litho.widget.RecyclerBinder;
import com.sst.android.dailynews.data.db.database.Database;
import com.sst.android.dailynews.lithoComponents.ListItem;
import com.sst.android.dailynews.lithoComponents.Recycler;
import com.sst.android.dailynews.util.DbUtil;
import com.sst.android.dailynews.util.ListItemUtil;
import com.sst.android.dailynews.util.RecyclerUtil;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.annotations.NonNull;
import io.reactivex.subjects.PublishSubject;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final ComponentContext c = new ComponentContext(this);

        Database db = DbUtil.getAppDb(getApplicationContext());
        PublishSubject<List<com.sst.android.dailynews.data.model.ListItem>> listPublishSubject = PublishSubject.create();
        listPublishSubject.subscribe((items) -> {

            items.forEach(item->{
                db.articleDao().addArticle(item.getArticle());
            });
            runOnUiThread(()->{
                setContentView(
                        LithoView.create(
                                this,
                                Recycler.create(c)
                                        .binder(RecyclerUtil.createRecyclerBinder(c, this, items))
                                        .build()
                        )
                );
            });
        },
        throwable -> {
            Log.d("MainActivity", throwable.getMessage());
        },
        ()->{});

        new Thread(()->{
            ListItemUtil.createNewsArticleLists(c, listPublishSubject, db.articleDao().getArticles());
        }).start();


    }

}

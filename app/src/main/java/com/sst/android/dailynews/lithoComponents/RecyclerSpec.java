package com.sst.android.dailynews.lithoComponents;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;

import com.facebook.litho.Component;
import com.facebook.litho.ComponentContext;
import com.facebook.litho.ComponentLayout;
import com.facebook.litho.annotations.LayoutSpec;
import com.facebook.litho.annotations.OnCreateLayout;
import com.facebook.litho.annotations.Prop;
import com.facebook.litho.widget.ComponentRenderInfo;
import com.facebook.litho.widget.Recycler;
import com.facebook.litho.widget.RecyclerBinder;
import com.squareup.picasso.Picasso;
import com.sst.android.dailynews.data.model.Article;
import com.sst.android.dailynews.data.model.News;
import com.sst.android.dailynews.util.HttpUtil;

import java.io.IOException;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by kathires on 10/19/17.
 */

@LayoutSpec
public class RecyclerSpec {

    private static RecyclerBinder recyclerBinder;
    private static Article article;

    @OnCreateLayout
    static ComponentLayout onCreateLayout(ComponentContext c, @Prop RecyclerBinder binder) {

        recyclerBinder = binder;
        return Recycler.create(c).binder(recyclerBinder).buildWithLayout();
    }

    private static void addList(Component<ListItem> item) {
        recyclerBinder.appendItem(ComponentRenderInfo.create()
                .component(item)
                .build());
    }

}

package com.sst.android.dailynews.util;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.OrientationHelper;

import com.facebook.litho.Component;
import com.facebook.litho.ComponentContext;
import com.facebook.litho.widget.ComponentRenderInfo;
import com.facebook.litho.widget.LinearLayoutInfo;
import com.facebook.litho.widget.RecyclerBinder;
import com.sst.android.dailynews.data.model.ListItem;
import com.sst.android.dailynews.lithoComponents.Recycler;

import java.util.List;

/**
 * Created by kathires on 10/20/17.
 */

public class RecyclerUtil {

    public static RecyclerBinder createRecyclerBinder(ComponentContext context, Activity activity, List<ListItem> listItemList) {
        final RecyclerBinder binder = new RecyclerBinder.Builder().
                layoutInfo(new LinearLayoutInfo(activity, OrientationHelper.VERTICAL, false)).
                build(context);
        //listItemList.forEach(listItem -> {
        int len = listItemList.size();
        for (int i=0; i<len; i++){
            ListItem listItem = listItemList.get(i);
            binder.appendItem(ComponentRenderInfo.create()
                    .component(
                            com.sst.android.dailynews.lithoComponents.ListItem.create(context)
                                    .article(listItem.getArticle())
                                    .drawable(listItem.getBitmapDrawable())
                                    .build()
                    )
                    .build());
        }
        //});

        return binder;
    }

}

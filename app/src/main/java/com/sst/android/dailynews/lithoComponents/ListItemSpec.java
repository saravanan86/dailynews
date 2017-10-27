package com.sst.android.dailynews.lithoComponents;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.annotation.AttrRes;
import android.support.annotation.DimenRes;
import android.support.annotation.Dimension;
import android.support.annotation.StyleRes;
import android.support.v4.app.NotificationCompat;
import android.text.TextUtils;
import android.text.style.StyleSpan;

import com.facebook.litho.Border;
import com.facebook.litho.Column;
import com.facebook.litho.ComponentContext;
import com.facebook.litho.ComponentLayout;
import com.facebook.litho.annotations.LayoutSpec;
import com.facebook.litho.annotations.OnCreateLayout;
import com.facebook.litho.annotations.Prop;
import com.facebook.litho.annotations.ResType;
import com.facebook.litho.widget.Card;
import com.facebook.litho.widget.Image;
import com.facebook.litho.widget.Text;
import com.facebook.litho.widget.VerticalGravity;
import com.facebook.yoga.YogaAlign;
import com.facebook.yoga.YogaEdge;
import com.facebook.yoga.YogaPositionType;
import com.squareup.picasso.Picasso;
import com.sst.android.dailynews.R;
import com.sst.android.dailynews.data.model.Article;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * Created by kathires on 10/18/17.
 */

@LayoutSpec
public class ListItemSpec {

    @OnCreateLayout
    static ComponentLayout onCreateLayout(ComponentContext c, @Prop Article article, @Prop Drawable drawable) {

        return Column.create(c)
                .child(
                    Text.create(c)
                        .text(article.getTitle())
                        .textSizeSp(14)
                        .textStyle(1)
                        .maxLines(1)
                        .ellipsize(TextUtils.TruncateAt.END)
                        .build()
                )
                .child(
                    Text.create(c)
                        .text(article.getDescription())
                        .positionType(YogaPositionType.ABSOLUTE)
                        .paddingPx(YogaEdge.TOP, 50)
                        .paddingPx(YogaEdge.LEFT,225)
                        .maxLines(4)
                        .ellipsize(TextUtils.TruncateAt.END)
                        .textSizeSp(14)
                        .alignSelf(YogaAlign.FLEX_START)
                        .build()
                )
                .child(
                    Image.create(c)
                        .drawable(drawable)
                        .heightPx(200)
                        .widthPx(200)
                        .paddingPercent(YogaEdge.BOTTOM,2)
                        .build()
                )
                .child(
                    Text.create(c)
                        .text(article.getAuthor() != null ? "Author: "+article.getAuthor() : "")
                        .textSizeSp(14)
                        .textStyle(3)
                        .positionType(YogaPositionType.ABSOLUTE)
                        .positionDip(YogaEdge.BOTTOM, Dimension.PX)
                        .alignSelf(YogaAlign.BASELINE)
                        .alignSelf(YogaAlign.FLEX_START)
                        .build()
                )
                .child(
                        Text.create(c)
                                .text((article.getPublishedAt() != null ? article.getPublishedAt().substring(0,article.getPublishedAt().indexOf("T")) : ""))
                                .textSizeSp(14)
                                .textStyle(2)
                                .positionType(YogaPositionType.ABSOLUTE)
                                .positionDip(YogaEdge.BOTTOM, Dimension.PX)
                                .alignSelf(YogaAlign.FLEX_END)
                                .build()
                )
                .border(
                        Border.create(c)
                                .widthPx(YogaEdge.BOTTOM, 5)
                                .color(YogaEdge.BOTTOM, Color.BLUE)
                                .build()
                )
                .heightPx(300)
                .build();
    }

}

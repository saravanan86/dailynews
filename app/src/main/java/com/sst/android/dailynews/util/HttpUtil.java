package com.sst.android.dailynews.util;

import com.sst.android.dailynews.data.remote.NewsService;
import com.sst.android.dailynews.data.remote.RetrofitClient;

/**
 * Created by kathires on 10/17/17.
 */

public class HttpUtil {

    public static final String BASE_URL = "https://newsapi.org/";

    public static NewsService getNewsService() {
        return RetrofitClient.getClient(BASE_URL).create(NewsService.class);
    }

}

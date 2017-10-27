package com.sst.android.dailynews.data.remote;

import com.sst.android.dailynews.data.model.News;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by kathires on 10/17/17.
 */

public interface NewsService {

    /*@GET("v1/articles?source=techcrunch&sortBy=top&apiKey=94ad4c3e4c3540faab7204b34fc16532")
    Call<News> getNews();

    @GET("v1/articles?source=techcrunch&sortBy=top&apiKey=94ad4c3e4c3540faab7204b34fc16532")
    Observable<News> getNewsObservable();*/

    @GET("v1/articles?source=cnn&sortBy=top&apiKey=94ad4c3e4c3540faab7204b34fc16532")
    Call<News> getNews();

    @GET("v1/articles?source=cnn&sortBy=top&apiKey=94ad4c3e4c3540faab7204b34fc16532")
    Observable<News> getNewsObservable();

}

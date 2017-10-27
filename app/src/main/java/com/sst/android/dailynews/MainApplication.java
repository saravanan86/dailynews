package com.sst.android.dailynews;

import android.app.Application;

import com.facebook.soloader.SoLoader;

/**
 * Created by kathires on 10/17/17.
 */

public class MainApplication extends Application {

    @Override
    public void onCreate(){
        super.onCreate();
        SoLoader.init(this, false);
    }

}

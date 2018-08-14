package app.hb.androidarchcompo;

import android.app.Application;

import timber.log.Timber;

public class BasicApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        if (BuildConfig.DEBUG) Timber.plant(new Timber.DebugTree());
    }

}

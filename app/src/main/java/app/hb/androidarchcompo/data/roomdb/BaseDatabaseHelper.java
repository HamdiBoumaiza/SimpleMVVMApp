package app.hb.androidarchcompo.data.roomdb;

import android.content.Context;

class BaseDatabaseHelper {

    AppDatabase appDatabase;

    BaseDatabaseHelper(Context context) {
        appDatabase = AppDatabase.getInstance(context);
    }
}

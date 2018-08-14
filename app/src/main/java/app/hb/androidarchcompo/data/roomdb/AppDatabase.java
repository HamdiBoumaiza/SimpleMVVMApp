package app.hb.androidarchcompo.data.roomdb;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import app.hb.androidarchcompo.data.model.PhotoModel;
import app.hb.androidarchcompo.data.roomdb.dao.PhotoDao;


@Database(entities = PhotoModel.class, version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {

    public static final String DATABASE_DB = "app.hb.androidarchcompo";
    private static AppDatabase appDatabase;

    public static AppDatabase getInstance(Context context) {
        if (appDatabase == null) {
            appDatabase = Room.databaseBuilder(context, AppDatabase.class, DATABASE_DB).allowMainThreadQueries().build();
        }
        return appDatabase;
    }

    public abstract PhotoDao getPhotoDao();
}

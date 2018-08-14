package app.hb.androidarchcompo.data.roomdb;

import android.arch.lifecycle.LiveData;
import android.content.Context;

import java.util.List;

import app.hb.androidarchcompo.data.model.PhotoModel;
import app.hb.androidarchcompo.data.roomdb.dao.PhotoDao;


public class PhotoDatabaseHelper extends BaseDatabaseHelper {

    private PhotoDao photoDao;

    public PhotoDatabaseHelper(Context context) {
        super(context);
        photoDao = appDatabase.getPhotoDao();
    }

    public LiveData<List<PhotoModel>> getAll() {
        return photoDao.getAll();
    }

    public void save(List<PhotoModel> photos) {
        photoDao.insert(photos);
    }
}

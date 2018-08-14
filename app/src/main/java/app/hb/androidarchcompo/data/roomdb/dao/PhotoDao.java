package app.hb.androidarchcompo.data.roomdb.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Query;

import java.util.List;

import app.hb.androidarchcompo.data.model.PhotoModel;

@Dao
public interface PhotoDao extends BaseDao<PhotoModel> {

    @Query("select * from PhotoModel")
    LiveData<List<PhotoModel>> getAll();
}


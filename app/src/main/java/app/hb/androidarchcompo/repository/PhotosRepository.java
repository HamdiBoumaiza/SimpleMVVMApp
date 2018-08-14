package app.hb.androidarchcompo.repository;

import android.annotation.SuppressLint;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.content.Context;

import java.util.List;

import app.hb.androidarchcompo.data.model.PhotoModel;
import app.hb.androidarchcompo.data.network.ApiInterface;
import app.hb.androidarchcompo.data.network.Client;
import app.hb.androidarchcompo.data.roomdb.PhotoDatabaseHelper;
import app.hb.androidarchcompo.utils.NetworkHelper;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import timber.log.Timber;

public class PhotosRepository {

    public PhotosRepository() {
    }

    @SuppressLint("CheckResult")
    public LiveData<List<PhotoModel>> getPhotosWS(Context mContext) {
        MutableLiveData<List<PhotoModel>> data = new MutableLiveData<>();
        PhotoDatabaseHelper photoDatabaseHelper = new PhotoDatabaseHelper(mContext);

        ApiInterface apiService = Client.getInstance(mContext).getService();

        if (NetworkHelper.isInternetExist(mContext)) {
            apiService.getPhotos()
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribeOn(Schedulers.io())
                    .subscribe(myData -> {
                        data.setValue(myData);
                        photoDatabaseHelper.save(myData);
                    }, throwable -> Timber.e("onError :: " + throwable.getMessage()));

            return data;
        } else {
            return photoDatabaseHelper.getAll();
        }
    }

}

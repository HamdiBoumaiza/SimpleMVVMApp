package app.hb.androidarchcompo.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.content.Context;
import android.support.annotation.NonNull;

import java.util.List;

import app.hb.androidarchcompo.data.model.PhotoModel;
import app.hb.androidarchcompo.repository.PhotosRepository;

public class PhotosViewModel extends AndroidViewModel {

    private PhotosRepository photosRepository = new PhotosRepository();


    public PhotosViewModel(@NonNull Application application) {
        super(application);
    }

    public LiveData<List<PhotoModel>> getArrayPhotos(Context mContext) {
        return photosRepository.getPhotosWS(mContext);
    }


}

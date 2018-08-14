package app.hb.androidarchcompo.data.network;

import java.util.List;

import app.hb.androidarchcompo.data.model.PhotoModel;
import io.reactivex.Single;
import retrofit2.http.GET;

public interface ApiInterface {

    @GET("contacts.php?source=linkedin")
    Single<List<PhotoModel>> getPhotos();

}

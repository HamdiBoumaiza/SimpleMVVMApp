package app.hb.androidarchcompo.data.model;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;
import android.databinding.BindingAdapter;
import android.support.annotation.NonNull;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.google.gson.annotations.Expose;

import app.hb.androidarchcompo.R;

@Entity
public class PhotoModel {

    @PrimaryKey
    @NonNull
    @Expose
    private String name;

    @Expose
    private String email;

    @Expose
    private String phone;

    @Expose
    private String image;


    @Ignore
    public PhotoModel() {
    }


    public PhotoModel(String name, String email, String phone, String image) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.image = image;
    }

    @BindingAdapter("android:src")
    public static void setImageUrl(ImageView view, String url) {
        Glide.with(view.getContext())
                .applyDefaultRequestOptions(new RequestOptions()
                        .placeholder(R.color.colorWhite)
                        .error(R.color.colorWhite)
                        .centerCrop())
                .load(url)
                .into(view);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}

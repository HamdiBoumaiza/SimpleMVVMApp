package app.hb.androidarchcompo.view;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import app.hb.androidarchcompo.R;
import app.hb.androidarchcompo.data.model.PhotoModel;
import app.hb.androidarchcompo.databinding.ActivityMainBinding;
import app.hb.androidarchcompo.view.adapter.PhotoAdapter;
import app.hb.androidarchcompo.viewmodel.PhotosViewModel;

public class MainActivity extends AppCompatActivity {

    private Context mContext;
    private PhotoAdapter photoAdapter;
    private List<PhotoModel> modelArrayList = new ArrayList<>();
    private PhotosViewModel viewModel;
    private ActivityMainBinding mainBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        mContext = MainActivity.this ;

        viewModel = ViewModelProviders.of(this).get(PhotosViewModel.class);

        initRecycler();
    }

    private void initRecycler() {
        mainBinding.recyclerPhotos.setLayoutManager(new GridLayoutManager(mContext, 2));
        photoAdapter = new PhotoAdapter(modelArrayList);
        mainBinding.recyclerPhotos.setAdapter(photoAdapter);
        updateUI();
    }


    private void updateUI() {
        viewModel.getArrayPhotos(mContext).observe(this, photoModelArrayList -> {
            mainBinding.progressBar.setVisibility(View.GONE);
            if (photoModelArrayList.size() != 0) {
                photoAdapter.addPhotoModelArrayList(photoModelArrayList);
            } else {
                Toast.makeText(mContext, mContext.getString(R.string.no_data), Toast.LENGTH_SHORT).show();
            }
        });
    }


}

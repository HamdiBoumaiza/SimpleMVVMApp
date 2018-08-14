package app.hb.androidarchcompo.view.adapter;

import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.List;

import app.hb.androidarchcompo.R;
import app.hb.androidarchcompo.data.model.PhotoModel;
import app.hb.androidarchcompo.databinding.ItemPhotosBinding;


public class PhotoAdapter extends RecyclerView.Adapter<PhotoAdapter.ViewHolder> {

    private List<PhotoModel> photoModelArrayList;
    private ItemPhotosBinding viewDataBinding;

    public PhotoAdapter(List<PhotoModel> photoModelArrayList) {
        this.photoModelArrayList = photoModelArrayList;
    }


    public void addPhotoModelArrayList(List<PhotoModel> photoModelArray) {
        photoModelArrayList.addAll(photoModelArray);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        viewDataBinding = DataBindingUtil.inflate(LayoutInflater.from(viewGroup.getContext()), R.layout.item_photos, viewGroup, false);
        return new ViewHolder(viewDataBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        PhotoModel photoModel = photoModelArrayList.get(position);
        viewDataBinding.setPhotosModel(photoModel);
    }

    @Override
    public int getItemCount() {
        return photoModelArrayList == null ? 0 : photoModelArrayList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(ItemPhotosBinding itemView) {
            super(itemView.getRoot());
        }
    }
}
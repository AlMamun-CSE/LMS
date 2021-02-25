package com.techdsf.lms.ui.category;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.techdsf.lms.R;

import java.util.ArrayList;
import java.util.List;

public class CategoryItemListAdapter extends RecyclerView.Adapter<CategoryItemListAdapter.ViewHolder> {

    private Context context;
    private List<CategoryItemModel>categoryItemModelsList;

    public CategoryItemListAdapter(Context context, List<CategoryItemModel> categoryItemModelsList) {
        this.context = context;
        this.categoryItemModelsList = categoryItemModelsList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.sample_category_item,viewGroup,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        int image = categoryItemModelsList.get(position).getCategoryItemImage();
        String name = categoryItemModelsList.get(position).getCategoryName();

        holder.categoryImage.setImageResource(image);
        holder.categoryName.setText(name);
    }

    @Override
    public int getItemCount() {
        return categoryItemModelsList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView categoryImage;
        private TextView categoryName;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            categoryImage = itemView.findViewById(R.id.categoryProfileImageId);
            categoryName = itemView.findViewById(R.id.categoryNameId);
        }

        private void setCategoryImage(int resource){
            categoryImage.setImageResource(resource);
        }
        private void setCategoryName(String name){
            categoryName.setText(name);
        }
    }
}

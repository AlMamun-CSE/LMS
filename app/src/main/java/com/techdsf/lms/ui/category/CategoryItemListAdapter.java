package com.techdsf.lms.ui.category;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.techdsf.lms.R;

import java.util.ArrayList;
import java.util.List;

public class CategoryItemListAdapter extends RecyclerView.Adapter<CategoryItemListAdapter.ViewHolder> implements Filterable {

    private Context context;
    private List<CategoryItemModel>categoryItemModelsList;
    ArrayList<CategoryItemModel> backup;
    private View.OnClickListener mOnItemClickListener;

    //TODO: Step 2 of 4: Assign itemClickListener to your local View.OnClickListener variable
    public void setOnItemClickListener(View.OnClickListener itemClickListener) {
        mOnItemClickListener = itemClickListener;
    }

    public CategoryItemListAdapter(Context context, List<CategoryItemModel> categoryItemModelsList) {
        this.context = context;
        this.categoryItemModelsList = categoryItemModelsList;
        backup=new ArrayList<>(categoryItemModelsList);
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
//        holder.itemView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//            }
//        });
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
            //TODO: Step 3 of 4: setTag() as current view holder along with
            // setOnClickListener() as your local View.OnClickListener variable.
            // You can set the same mOnItemClickListener on multiple views if required
            // and later differentiate those clicks using view's id.
            itemView.setTag(this);
            itemView.setOnClickListener(mOnItemClickListener);
        }

        private void setCategoryImage(int resource){
            categoryImage.setImageResource(resource);
        }
        private void setCategoryName(String name){
            categoryName.setText(name);
        }
    }



    @Override
    public Filter getFilter() {
        return filter;
    }

    Filter filter=new Filter() {
        @Override
        // background thread
        protected FilterResults performFiltering(CharSequence keyword)
        {
            ArrayList<CategoryItemModel> filtereddata=new ArrayList<>();

            if(keyword.toString().isEmpty())
                filtereddata.addAll(backup);
            else
            {
                for(CategoryItemModel obj : backup)
                {
                    if(obj.getCategoryName().toString().toLowerCase().contains(keyword.toString().toLowerCase()))
                        filtereddata.add(obj);
                }
            }

            FilterResults results=new FilterResults();
            results.values=filtereddata;
            return results;
        }

        @Override  // main UI thread
        protected void publishResults(CharSequence constraint, FilterResults results)
        {
            categoryItemModelsList.clear();
            categoryItemModelsList.addAll((ArrayList<CategoryItemModel>)results.values);
            notifyDataSetChanged();
        }
    };
}

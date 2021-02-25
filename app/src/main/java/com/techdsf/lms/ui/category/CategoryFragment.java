package com.techdsf.lms.ui.category;

import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.techdsf.lms.R;
import com.techdsf.lms.activity.MainActivity;
import com.techdsf.lms.ui.home.Horizontal_Course_Adapter;
import com.techdsf.lms.ui.home.Horizontal_Course_Model;

import java.util.ArrayList;
import java.util.List;

public class CategoryFragment extends Fragment {
    private static final String TAG = "CategoryFragment";

    private RecyclerView recyclerView;
    private EditText editTextSearch;

    private CategoryViewModel categoryViewModel;
    private boolean isScrolling = false;
    LinearLayoutManager manager;
    int currentItem, totalItem, scrollOutItem;
    List<CategoryItemModel> categoryItemModelList;
    CategoryItemListAdapter adapter;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        categoryViewModel = new ViewModelProvider(this).get(CategoryViewModel.class);
        View root = inflater.inflate(R.layout.fragment_category, container, false);
        recyclerView = root.findViewById(R.id.categoryRecyclerViewId);
        editTextSearch = root.findViewById(R.id.editTextSearchCategory);
        manager = new LinearLayoutManager(getContext());

        recyclerViewFeatured();


        return root;
    }






    private void recyclerViewFeatured() {
        categoryItemModelList = new ArrayList<>();

        categoryItemModelList.add(new CategoryItemModel(R.drawable.ic_action_name, "Graphic Design"));
        categoryItemModelList.add(new CategoryItemModel(R.drawable.ic__web_design, "Web Design"));
        categoryItemModelList.add(new CategoryItemModel(R.drawable.ic_anroid, "Android & iOS"));
        categoryItemModelList.add(new CategoryItemModel(R.drawable.ic_action_name, "Cyber Security"));
        categoryItemModelList.add(new CategoryItemModel(R.drawable.ic__web_design, "Photoshop"));
        categoryItemModelList.add(new CategoryItemModel(R.drawable.ic_anroid, "Digital Market"));
        categoryItemModelList.add(new CategoryItemModel(R.drawable.ic_action_name, "Game Design"));
        categoryItemModelList.add(new CategoryItemModel(R.drawable.ic__web_design, "3D &Animation"));
        categoryItemModelList.add(new CategoryItemModel(R.drawable.ic_anroid, "Design Thinking"));
        categoryItemModelList.add(new CategoryItemModel(R.drawable.ic_action_name, "Design Tool"));
        categoryItemModelList.add(new CategoryItemModel(R.drawable.ic__web_design, "Data Analysis"));
        categoryItemModelList.add(new CategoryItemModel(R.drawable.ic_anroid, "Artifial Intelligence"));
        categoryItemModelList.add(new CategoryItemModel(R.drawable.ic_action_name, "Hardware"));
        categoryItemModelList.add(new CategoryItemModel(R.drawable.ic__web_design, "Operations"));
        categoryItemModelList.add(new CategoryItemModel(R.drawable.ic_anroid, "Management"));


        adapter = new CategoryItemListAdapter(getContext(), categoryItemModelList);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);

        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();

//        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
//            @Override
//            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
//                super.onScrollStateChanged(recyclerView, newState);
//                if (newState == AbsListView.OnScrollListener.SCROLL_STATE_FLING){
//                    isScrolling = true;
//                }
//            }
//
//            @Override
//            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
//                super.onScrolled(recyclerView, dx, dy);
//                currentItem = manager.getChildCount();
//                totalItem = manager.getItemCount();
//                scrollOutItem = manager.findFirstVisibleItemPosition();
//
//                if (isScrolling && (scrollOutItem + currentItem== totalItem))
//                {
//                    //fetch data
//                    isScrolling = false;
//                    fetchData();
//                }
//            }
//        });
    }

    private void fetchData() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 7; i++) {
                    categoryItemModelList.add(new CategoryItemModel(R.drawable.ic_anroid, "Management"));
                    categoryItemModelList.add(new CategoryItemModel(R.drawable.ic_anroid, "Management"));
                    categoryItemModelList.add(new CategoryItemModel(R.drawable.ic_anroid, "Management"));
                    categoryItemModelList.add(new CategoryItemModel(R.drawable.ic_anroid, "Management"));
                    categoryItemModelList.add(new CategoryItemModel(R.drawable.ic_anroid, "Management"));
                    categoryItemModelList.add(new CategoryItemModel(R.drawable.ic_anroid, "Management"));

                    adapter.notifyDataSetChanged();
                }
            }
        }, 3000);
    }
}
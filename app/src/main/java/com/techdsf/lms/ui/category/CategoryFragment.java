package com.techdsf.lms.ui.category;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;

import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.techdsf.lms.R;
import com.techdsf.lms.activity.CourseCategoryActivity;

import java.util.ArrayList;
import java.util.List;

public class CategoryFragment extends Fragment {
    private static final String TAG = "CategoryFragment";

    private RecyclerView recyclerView;
    private Toolbar toolbar;

    private CategoryViewModel categoryViewModel;
    private boolean isScrolling = false;
    LinearLayoutManager manager;
    int currentItem, totalItem, scrollOutItem;
    List<CategoryItemModel> categoryItemModelList;
    CategoryItemListAdapter adapter;



    private View.OnClickListener onItemClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            //TODO: Step 4 of 4: Finally call getTag() on the view.
            // This viewHolder will have all required values.
            RecyclerView.ViewHolder viewHolder = (RecyclerView.ViewHolder) view.getTag();
            int position = viewHolder.getAdapterPosition();
            // viewHolder.getItemId();
            // viewHolder.getItemViewType();
            // viewHolder.itemView;
            CategoryItemModel thisItem = categoryItemModelList.get(position);
            Toast.makeText(getActivity(), "You Clicked: " + thisItem.getCategoryName(), Toast.LENGTH_SHORT).show();

            Intent intent = new Intent(getActivity().getApplication(),CourseCategoryActivity.class);
            startActivity(intent);

        }
    };





    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        categoryViewModel = new ViewModelProvider(this).get(CategoryViewModel.class);
        View root = inflater.inflate(R.layout.fragment_category, container, false);
        toolbar = root.findViewById(R.id.appbarlayout_tool_bar);

        setHasOptionsMenu(true);
        getActivity().setTitle("");
        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);

        recyclerView = root.findViewById(R.id.categoryRecyclerViewId);
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

        //TODO: Step 1 of 4: Create and set OnItemClickListener to the adapter.
        adapter.setOnItemClickListener(onItemClickListener);


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

//    private void fetchData() {
//        new Handler().postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                for (int i = 0; i < 7; i++) {
//                    categoryItemModelList.add(new CategoryItemModel(R.drawable.ic_anroid, "Management"));
//                    categoryItemModelList.add(new CategoryItemModel(R.drawable.ic_anroid, "Management"));
//                    categoryItemModelList.add(new CategoryItemModel(R.drawable.ic_anroid, "Management"));
//                    categoryItemModelList.add(new CategoryItemModel(R.drawable.ic_anroid, "Management"));
//                    categoryItemModelList.add(new CategoryItemModel(R.drawable.ic_anroid, "Management"));
//                    categoryItemModelList.add(new CategoryItemModel(R.drawable.ic_anroid, "Management"));
//
//                    adapter.notifyDataSetChanged();
//                }
//            }
//        }, 3000);
//    }


    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        inflater.inflate(R.menu.main, menu);
        MenuItem item=menu.findItem(R.id.search_menu);
        item.setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM |  MenuItem.SHOW_AS_ACTION_COLLAPSE_ACTION_VIEW);
        item.setIcon(R.drawable.ic_baseline_search_24);

        SearchView searchView=(SearchView)item.getActionView();
        item.collapseActionView();

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText)
            {
                adapter.getFilter().filter(newText);
                return false;
            }
        });
        super.onCreateOptionsMenu(menu, inflater);
    }
}
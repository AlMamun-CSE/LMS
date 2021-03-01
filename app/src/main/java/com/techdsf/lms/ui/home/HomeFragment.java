package com.techdsf.lms.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.techdsf.lms.R;
import com.techdsf.lms.activity.MainActivity;
import com.techdsf.lms.ui.category.CategoryFragment;

import java.util.ArrayList;
import java.util.List;

import static com.techdsf.lms.ui.home.Horizontal_Course_Model.HORIZONTAL_LAYOUT;

public class HomeFragment extends Fragment{

    private HomeViewModel homeViewModel;

    private TextView courseTitle;
    private Button viewAllButton;
    private RecyclerView recyclerView;
    private Button viewAllPopularCategory;
    private FrameLayout frameLayout;
    public static List<Horizontal_Course_Model>horizontalCourseModelList;



    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);

        ImageSlider imageSlider = root.findViewById(R.id.image_slider);
        courseTitle = root.findViewById(R.id.horizontal_scroll_layout_course_titleId);
        viewAllButton = root.findViewById(R.id.horizontal_scroll_layout_view_allId);
        recyclerView = root.findViewById(R.id.course_recyclerView_id);
        viewAllPopularCategory = root.findViewById(R.id.horizontal_scroll_layout_viewAll);
        frameLayout = root.findViewById(R.id.main_container);

        BottomNavigationView navigation = root.findViewById(R.id.nav_view);


        viewAllPopularCategory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment = new CategoryFragment();
                FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.fragment_container,fragment);
                fragmentTransaction.commitNow();

                MainActivity.navigation.setSelectedItemId(R.id.navigation_category);
            }
        });
        recyclerViewFeatured();



        List<SlideModel> slideModels = new ArrayList<>();

        slideModels.add(new SlideModel("https://www.wonderplugin.com/wp-content/uploads/2019/05/tutorial-computer-900x288.jpg", ScaleTypes.FIT));
        slideModels.add(new SlideModel("https://www.jssor.com/premium/ski/img/dreamstime_m_103202288-duotone.jpg", ScaleTypes.FIT));
        slideModels.add(new SlideModel("https://www.wonderplugin.com/wp-content/uploads/2019/05/tutorial-computer-900x288.jpg",ScaleTypes.FIT));
        imageSlider.setImageList(slideModels, ScaleTypes.FIT);


        return root;
    }

    private void recyclerViewFeatured() {
        horizontalCourseModelList = new ArrayList<>();

        horizontalCourseModelList.add(new Horizontal_Course_Model(HORIZONTAL_LAYOUT,R.drawable.image_2,"Academic","IELTS Vocabulary to Improve your Lexical Resource and Spoken","$500.00","(24)","21 Lesson","121 Section"));
        horizontalCourseModelList.add(new Horizontal_Course_Model(HORIZONTAL_LAYOUT,R.drawable.image_1,"Productivity","Android Development","$600.00","(24)","21 Lesson","121 Section"));
        horizontalCourseModelList.add(new Horizontal_Course_Model(HORIZONTAL_LAYOUT,R.drawable.image_3,"Academic","IELTS Vocabulary to Improve your Lexical Resource and Spoken","$500.00","(54)","11 Lesson","101 Section"));
        horizontalCourseModelList.add(new Horizontal_Course_Model(HORIZONTAL_LAYOUT,R.drawable.image_1,"Productivity","Android Development","$700.00","(24)","21 Lesson","121 Section"));
        horizontalCourseModelList.add(new Horizontal_Course_Model(HORIZONTAL_LAYOUT,R.drawable.image_4,"Academic","IELTS Vocabulary to Improve your Lexical Resource and Spoken","$500.00","(336)","36 Lesson","150 Section"));


        Horizontal_Course_Adapter adapter = new Horizontal_Course_Adapter(horizontalCourseModelList);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(),RecyclerView.HORIZONTAL,false);
        recyclerView.setLayoutManager(linearLayoutManager);

        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

}
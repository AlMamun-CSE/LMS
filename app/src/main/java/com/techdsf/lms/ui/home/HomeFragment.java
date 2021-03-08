package com.techdsf.lms.ui.home;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
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
import com.techdsf.lms.Activities.CourseCategoryActivity;
import com.techdsf.lms.Activities.MainActivity;
import com.techdsf.lms.ui.category.CategoryFragment;
import com.techdsf.lms.ui.courses.CoursesFragment;

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
    private LinearLayout linearLayout1;

    public static List<Horizontal_Course_Model>horizontalCourseModelList;



    @SuppressLint("ClickableViewAccessibility")
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);

        ImageSlider imageSlider = root.findViewById(R.id.image_slider);
        courseTitle = root.findViewById(R.id.horizontal_scroll_layout_course_titleId);
        viewAllButton = root.findViewById(R.id.horizontal_scroll_layout_view_all_popular_course_Id);
        recyclerView = root.findViewById(R.id.course_recyclerView_id);
        viewAllPopularCategory = root.findViewById(R.id.horizontal_scroll_layout_viewAll_popular_category_id);
        frameLayout = root.findViewById(R.id.main_container);
        linearLayout1 = root.findViewById(R.id.linLayout1Id);

        BottomNavigationView navigation = root.findViewById(R.id.nav_view);

//        linearLayout1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                setClickableAnimation(getContext(),v);
//                Intent intent = new Intent(getContext(), CourseCategoryActivity.class);
//                startActivity(intent);
//            }
//        });

        linearLayout1.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch(event.getAction())
                {
                    case MotionEvent.ACTION_DOWN:
                        break;
                    case MotionEvent.ACTION_UP:

                        //set color back to default
                        Intent intent = new Intent(getContext(), CourseCategoryActivity.class);
                        startActivity(intent);
                        break;
                }
                return true;
            }
        });

        viewAllButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment = new CoursesFragment();
                FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.fragment_container,fragment);
                fragmentTransaction.commitNow();

                MainActivity.navigation.setSelectedItemId(R.id.navigation_courses);
            }
        });
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


    //set Clickable Animation
    public static void setClickableAnimation(final Context context, final View view) {
        final int[] attrs = new int[]{R.attr.singleSelection};
        final TypedArray typedArray = context.obtainStyledAttributes(attrs);
        final int backgroundResource = typedArray.getResourceId(0, 0);
        view.setBackgroundResource(backgroundResource);
        typedArray.recycle();
    }

    private void recyclerViewFeatured() {
        horizontalCourseModelList = new ArrayList<>();

        horizontalCourseModelList.add(new Horizontal_Course_Model(HORIZONTAL_LAYOUT,R.drawable.image_2,"Academic","IELTS Vocabulary to Improve your Lexical Resource and Spoken","$500.00","(24)","21 Lesson","121 Section"));
        horizontalCourseModelList.add(new Horizontal_Course_Model(HORIZONTAL_LAYOUT,R.drawable.image_1,"Productivity","Android Development","$600.00","(24)","21 Lesson","121 Section"));
        horizontalCourseModelList.add(new Horizontal_Course_Model(HORIZONTAL_LAYOUT,R.drawable.image_3,"Academic","IELTS Vocabulary to Improve your Lexical Resource and Spoken","$500.00","(54)","11 Lesson","101 Section"));
        horizontalCourseModelList.add(new Horizontal_Course_Model(HORIZONTAL_LAYOUT,R.drawable.image_1,"Productivity","Android Development","$700.00","(24)","21 Lesson","121 Section"));
        horizontalCourseModelList.add(new Horizontal_Course_Model(HORIZONTAL_LAYOUT,R.drawable.image_4,"Academic","IELTS Vocabulary to Improve your Lexical Resource and Spoken","$500.00","(336)","36 Lesson","150 Section"));


        Horizontal_Course_Adapter adapter = new Horizontal_Course_Adapter(getContext(),horizontalCourseModelList);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(),RecyclerView.HORIZONTAL,false);
        recyclerView.setLayoutManager(linearLayoutManager);

        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

}
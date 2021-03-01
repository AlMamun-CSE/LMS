package com.techdsf.lms.ui.courses;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.techdsf.lms.R;
import com.techdsf.lms.ui.home.Horizontal_Course_Adapter;
import com.techdsf.lms.ui.home.Horizontal_Course_Model;

import java.util.ArrayList;
import java.util.List;

import static com.techdsf.lms.ui.home.HomeFragment.horizontalCourseModelList;
import static com.techdsf.lms.ui.home.Horizontal_Course_Model.HORIZONTAL_LAYOUT;
import static com.techdsf.lms.ui.home.Horizontal_Course_Model.VERTICAL_LAYOUT;

public class CoursesFragment extends Fragment {
    private static final String TAG = "CoursesFragment";

    private RecyclerView recyclerView;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_courses, container, false);
        Log.d(TAG, "onCreateView: started.");
        recyclerView = root.findViewById(R.id.course_vertical_recycler_Id);

        recyclerViewFeatured();


        return root;
    }

    private void recyclerViewFeatured() {
        horizontalCourseModelList = new ArrayList<>();

        horizontalCourseModelList.add(new Horizontal_Course_Model(VERTICAL_LAYOUT,R.drawable.image_2,"Academic","IELTS Vocabulary to Improve your Lexical Resource and Spoken","$500.00","$700.00","(24)","21 Lesson","121 Section"));
        horizontalCourseModelList.add(new Horizontal_Course_Model(VERTICAL_LAYOUT,R.drawable.image_1,"Productivity","Android Development","$600.00","$700.00","(24)","21 Lesson","121 Section"));
        horizontalCourseModelList.add(new Horizontal_Course_Model(VERTICAL_LAYOUT,R.drawable.image_3,"Academic","IELTS Vocabulary to Improve your Lexical Resource and Spoken","$500.00","$700.00","(54)","11 Lesson","101 Section"));
        horizontalCourseModelList.add(new Horizontal_Course_Model(VERTICAL_LAYOUT,R.drawable.image_1,"Productivity","Android Development","$700.00","$700.00","(24)","21 Lesson","121 Section"));
        horizontalCourseModelList.add(new Horizontal_Course_Model(VERTICAL_LAYOUT,R.drawable.image_4,"Academic","IELTS Vocabulary to Improve your Lexical Resource and Spoken","$500.00","$700.00","(336)","36 Lesson","150 Section"));
        horizontalCourseModelList.add(new Horizontal_Course_Model(VERTICAL_LAYOUT,R.drawable.image_4,"Academic","IELTS Vocabulary to Improve your Lexical Resource and Spoken","$500.00","$700.00","(336)","36 Lesson","150 Section"));
        horizontalCourseModelList.add(new Horizontal_Course_Model(VERTICAL_LAYOUT,R.drawable.image_4,"Academic","IELTS Vocabulary to Improve your Lexical Resource and Spoken","$500.00","$700.00","(336)","36 Lesson","150 Section"));
        horizontalCourseModelList.add(new Horizontal_Course_Model(VERTICAL_LAYOUT,R.drawable.image_4,"Academic","IELTS Vocabulary to Improve your Lexical Resource and Spoken","$500.00","$700.00","(336)","36 Lesson","150 Section"));
        horizontalCourseModelList.add(new Horizontal_Course_Model(VERTICAL_LAYOUT,R.drawable.image_4,"Academic","IELTS Vocabulary to Improve your Lexical Resource and Spoken","$500.00","$700.00","(336)","36 Lesson","150 Section"));
        horizontalCourseModelList.add(new Horizontal_Course_Model(VERTICAL_LAYOUT,R.drawable.image_4,"Academic","IELTS Vocabulary to Improve your Lexical Resource and Spoken","$500.00","$700.00","(336)","36 Lesson","150 Section"));
        horizontalCourseModelList.add(new Horizontal_Course_Model(VERTICAL_LAYOUT,R.drawable.image_2,"Productivity","Android Development","$800.00","$700.00","(24)","21 Lesson","121 Section"));
        horizontalCourseModelList.add(new Horizontal_Course_Model(VERTICAL_LAYOUT,R.drawable.image_2,"Productivity","Android Development","$800.00","$700.00","(24)","21 Lesson","121 Section"));
        horizontalCourseModelList.add(new Horizontal_Course_Model(VERTICAL_LAYOUT,R.drawable.image_2,"Productivity","Android Development","$800.00","$700.00","(24)","21 Lesson","121 Section"));
        horizontalCourseModelList.add(new Horizontal_Course_Model(VERTICAL_LAYOUT,R.drawable.image_2,"Productivity","Android Development","$800.00","$700.00","(24)","21 Lesson","121 Section"));
        horizontalCourseModelList.add(new Horizontal_Course_Model(VERTICAL_LAYOUT,R.drawable.image_2,"Productivity","Android Development","$800.00","$700.00","(24)","21 Lesson","121 Section"));
        horizontalCourseModelList.add(new Horizontal_Course_Model(VERTICAL_LAYOUT,R.drawable.image_2,"Productivity","Android Development","$800.00","$700.00","(24)","21 Lesson","121 Section"));


        Horizontal_Course_Adapter adapter = new Horizontal_Course_Adapter(horizontalCourseModelList);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), RecyclerView.VERTICAL,false);
        recyclerView.setLayoutManager(linearLayoutManager);

        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }
}
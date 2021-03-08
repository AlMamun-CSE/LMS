package com.techdsf.lms.ui.courses;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.widget.MediaController;
import android.widget.VideoView;

import com.techdsf.lms.R;
import com.techdsf.lms.ui.home.Horizontal_Course_Adapter;
import com.techdsf.lms.ui.home.Horizontal_Course_Model;

import java.util.ArrayList;

import static com.techdsf.lms.ui.home.HomeFragment.horizontalCourseModelList;
import static com.techdsf.lms.ui.home.Horizontal_Course_Model.VERTICAL_LAYOUT;

public class CourseDetails extends AppCompatActivity {
    private static final String TAG = "CourseDetails";

    private RecyclerView relatedCoursesRecyclerView;
    VideoView videoView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_details);
        Log.d(TAG, "onCreate: started.");


        //initialize widget............................
        relatedCoursesRecyclerView = findViewById(R.id.cDCoursesRelatedCoursesId);

        setupVideo();

        recyclerViewFeatured();

    }

    private void setupVideo() {
        videoView =(VideoView)findViewById(R.id.cDCoursesVideoPlayerId);
        MediaController mediaController= new MediaController(this);
        mediaController.setAnchorView(videoView);
        Uri uri=Uri.parse("rtsp://r9—sn-4g57knz7.googlevideo.com/Cj0LENy73wIaNAkTx-NXEcW9MhMYDSANFC3V20pYMOCoAUIASARgwbCRpeH9sPxWigELV3c4TllPNXQ1LUkM/A2AAF93B4F0422AA542E9687476E1B3A8D9E74A6.4A2A12D69ED5AC45F06D1FBBFCC3C110E39108A6/yt6/1/video.3gp");
        videoView.setMediaController(mediaController);
        videoView.setVideoURI(uri);
        videoView.requestFocus();
        videoView.start();

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


        Horizontal_Course_Adapter adapter = new Horizontal_Course_Adapter(this,horizontalCourseModelList);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL,false);
        relatedCoursesRecyclerView.setLayoutManager(linearLayoutManager);

        relatedCoursesRecyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }
}
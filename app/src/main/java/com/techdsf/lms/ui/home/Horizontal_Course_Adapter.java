package com.techdsf.lms.ui.home;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.techdsf.lms.R;

import java.util.List;

public class Horizontal_Course_Adapter extends RecyclerView.Adapter<Horizontal_Course_Adapter.ViewHolder> {

    private List<Horizontal_Course_Model> horizontal_course_models;

    public Horizontal_Course_Adapter(List<Horizontal_Course_Model> horizontal_course_models) {
        this.horizontal_course_models = horizontal_course_models;
    }

    @NonNull
    @Override
    public Horizontal_Course_Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {

        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.horizontal_course_scroll_item,viewGroup,false);


        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Horizontal_Course_Adapter.ViewHolder viewHolder, int position) {
        int image = horizontal_course_models.get(position).getCourseImage();
        String title = horizontal_course_models.get(position).getCourseTitle();
        String name = horizontal_course_models.get(position).getCourseName();
        String price = horizontal_course_models.get(position).getCoursePrice();
        String ratingNum = horizontal_course_models.get(position).getCourseRatingNumber();
        String lessonNum = horizontal_course_models.get(position).getCourseLessonNumber();
        String sectionNum = horizontal_course_models.get(position).getCourseSectionNumber();

        viewHolder.setCourseImage(image);
        viewHolder.setCourseTitle(title);
        viewHolder.setCourseName(name);
        viewHolder.setCoursePrice(price);
        viewHolder.setCourseRating(ratingNum);
        viewHolder.setCourseLesson(lessonNum);
        viewHolder.setCourseSection(sectionNum);
    }

    @Override
    public int getItemCount() {
        if (horizontal_course_models.size()>5){
            return 5;
        }else {
            return horizontal_course_models.size();
        }

    }


    public class ViewHolder extends RecyclerView.ViewHolder{
        private ImageView courseImage;
        private TextView courseTitle;
        private TextView courseName;
        private TextView coursePrice;
        private TextView courseRatingNumber;
        private TextView courseLessonNumber;
        private TextView courseSectionNumber;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            courseImage = itemView.findViewById(R.id.courseImageId);
            courseTitle = itemView.findViewById(R.id.courseTitleId);
            courseName = itemView.findViewById(R.id.courseNameId);
            coursePrice = itemView.findViewById(R.id.coursePriceId);
            courseRatingNumber=itemView.findViewById(R.id.courseRatingNumberId);
            courseLessonNumber=itemView.findViewById(R.id.courseLeassonId);
            courseSectionNumber=itemView.findViewById(R.id.courseSectionId);
        }
        private void setCourseImage(int resource){
            courseImage.setImageResource(resource);
        }
        private void setCourseTitle(String title){
            courseTitle.setText(title);
        }
        private void setCourseName(String name){
            courseName.setText(name);
        }
        private void setCoursePrice(String price){
            coursePrice.setText(price);
        }

        private void setCourseRating(String rating){
            courseRatingNumber.setText(rating);
        }
        private void setCourseLesson(String lesson){
            courseLessonNumber.setText(lesson);
        }
        private void setCourseSection(String section){
            courseSectionNumber.setText(section);
        }
    }
}

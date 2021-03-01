package com.techdsf.lms.ui.home;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.techdsf.lms.R;

import java.util.List;

import static com.techdsf.lms.ui.home.Horizontal_Course_Model.HORIZONTAL_LAYOUT;
import static com.techdsf.lms.ui.home.Horizontal_Course_Model.VERTICAL_LAYOUT;

public class Horizontal_Course_Adapter extends RecyclerView.Adapter{

    private List<Horizontal_Course_Model>horizontal_course_modelList;
    private int lastPosition = -1;

    public Horizontal_Course_Adapter(List<Horizontal_Course_Model> horizontal_course_modelList) {
        this.horizontal_course_modelList = horizontal_course_modelList;
    }

    @Override
    public int getItemViewType(int position) {
        switch (horizontal_course_modelList.get(position).getViewType()){
            case 0:
                return HORIZONTAL_LAYOUT;
            case 1:
                return VERTICAL_LAYOUT;
            default:
                return -1;
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        switch (viewType){
            case HORIZONTAL_LAYOUT:
                View horizontalView = LayoutInflater.from(parent.getContext()).inflate(R.layout.horizontal_course_scroll_item,parent,false);
                return new HorizontalView(horizontalView);
            case VERTICAL_LAYOUT:
                View verticalView = LayoutInflater.from(parent.getContext()).inflate(R.layout.sample_vertical_layout,parent,false);
                return new VerticalView(verticalView);
            default:
                return null;
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int position) {
        switch (horizontal_course_modelList.get(position).getViewType()){
            case HORIZONTAL_LAYOUT:
                int image = horizontal_course_modelList.get(position).getCourseImage();
                String title = horizontal_course_modelList.get(position).getCourseTitle();
                String name = horizontal_course_modelList.get(position).getCourseName();
                String price = horizontal_course_modelList.get(position).getCoursePrice();
                String ratingNum = horizontal_course_modelList.get(position).getCourseRatingNumber();
                String lessonNum = horizontal_course_modelList.get(position).getCourseLessonNumber();
                String sectionNum = horizontal_course_modelList.get(position).getCourseSectionNumber();

                ((HorizontalView)viewHolder).setCourseImage(image);
                ((HorizontalView)viewHolder).setCourseTitle(title);
                ((HorizontalView)viewHolder).setCourseName(name);
                ((HorizontalView)viewHolder).setCoursePrice(price);
                ((HorizontalView)viewHolder).setCourseRating(ratingNum);
                ((HorizontalView)viewHolder).setCourseLesson(lessonNum);
                ((HorizontalView)viewHolder).setCourseSection(sectionNum);
                break;
            case VERTICAL_LAYOUT:
                int image2 = horizontal_course_modelList.get(position).getCourseImage();
                String name2 = horizontal_course_modelList.get(position).getCourseName();
                String price2 = horizontal_course_modelList.get(position).getCoursePrice();
                String lossprice2 = horizontal_course_modelList.get(position).getLossCoursePrice();
                String ratingNum2 = horizontal_course_modelList.get(position).getCourseRatingNumber();
                String lessonNum2 = horizontal_course_modelList.get(position).getCourseLessonNumber();
                String sectionNum2 = horizontal_course_modelList.get(position).getCourseSectionNumber();

                ((VerticalView)viewHolder).setCourseImage2(image2);
                ((VerticalView)viewHolder).setCourseName2(name2);
                ((VerticalView)viewHolder).setCoursePrice2(price2);
                ((VerticalView)viewHolder).setCourseLossPrice2(lossprice2);
                ((VerticalView)viewHolder).setCourseRating2(ratingNum2);
                ((VerticalView)viewHolder).setCourseLesson2(lessonNum2);
                ((VerticalView)viewHolder).setCourseSection2(sectionNum2);
                break;
            default:
                return;
        }

        if (lastPosition < position){
            Animation animation = AnimationUtils.loadAnimation(viewHolder.itemView.getContext(), android.R.anim.fade_in);
            viewHolder.itemView.setAnimation(animation);
        }
    }

    @Override
    public int getItemCount() {
        return horizontal_course_modelList.size();
    }


    class HorizontalView extends RecyclerView.ViewHolder{

        private ImageView courseImage;
        private TextView courseTitle;
        private TextView courseName;
        private TextView coursePrice;
        private TextView courseRatingNumber;
        private TextView courseLessonNumber;
        private TextView courseSectionNumber;


        public HorizontalView(@NonNull View itemView) {
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

    class VerticalView extends RecyclerView.ViewHolder{

        private ImageView courseImage;
        private TextView courseTitle;
        private TextView courseName;
        private TextView coursePrice;
        private TextView courseLossPrice;
        private TextView courseRatingNumber;
        private TextView courseLessonNumber;
        private TextView courseSectionNumber;

        public VerticalView(@NonNull View itemView) {
            super(itemView);
            courseImage = itemView.findViewById(R.id.imageView4);
            courseName = itemView.findViewById(R.id.courseNameId);
            coursePrice = itemView.findViewById(R.id.coursePriceId);
            courseLossPrice = itemView.findViewById(R.id.lossPriceId);
            courseRatingNumber=itemView.findViewById(R.id.courseRatingNumberId);
            courseLessonNumber=itemView.findViewById(R.id.courseLeassonId);
            courseSectionNumber=itemView.findViewById(R.id.courseSectionId);
        }

        private void setCourseImage2(int resource){
            courseImage.setImageResource(resource);
        }
        private void setCourseName2(String name){
            courseName.setText(name);
        }
        private void setCoursePrice2(String price){
            coursePrice.setText(price);
        }
        private void setCourseLossPrice2(String lossPrice){
            courseLossPrice.setText(lossPrice);
        }

        private void setCourseRating2(String rating){
            courseRatingNumber.setText(rating);
        }
        private void setCourseLesson2(String lesson){
            courseLessonNumber.setText(lesson);
        }
        private void setCourseSection2(String section){
            courseSectionNumber.setText(section);
        }
    }


//    private List<Horizontal_Course_Model> horizontal_course_models;
//
//    public Horizontal_Course_Adapter(List<Horizontal_Course_Model> horizontal_course_models) {
//        this.horizontal_course_models = horizontal_course_models;
//    }
//
//    @NonNull
//    @Override
//    public Horizontal_Course_Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
//
//        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.horizontal_course_scroll_item,viewGroup,false);
//
//
//        return new ViewHolder(view);
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull Horizontal_Course_Adapter.ViewHolder viewHolder, int position) {
//        int image = horizontal_course_models.get(position).getCourseImage();
//        String title = horizontal_course_models.get(position).getCourseTitle();
//        String name = horizontal_course_models.get(position).getCourseName();
//        String price = horizontal_course_models.get(position).getCoursePrice();
//        String ratingNum = horizontal_course_models.get(position).getCourseRatingNumber();
//        String lessonNum = horizontal_course_models.get(position).getCourseLessonNumber();
//        String sectionNum = horizontal_course_models.get(position).getCourseSectionNumber();
//
//        viewHolder.setCourseImage(image);
//        viewHolder.setCourseTitle(title);
//        viewHolder.setCourseName(name);
//        viewHolder.setCoursePrice(price);
//        viewHolder.setCourseRating(ratingNum);
//        viewHolder.setCourseLesson(lessonNum);
//        viewHolder.setCourseSection(sectionNum);
//    }
//
//    @Override
//    public int getItemCount() {
//        if (horizontal_course_models.size()>5){
//            return 5;
//        }else {
//            return horizontal_course_models.size();
//        }
//
//    }
//
//
//    public class ViewHolder extends RecyclerView.ViewHolder{
//        private ImageView courseImage;
//        private TextView courseTitle;
//        private TextView courseName;
//        private TextView coursePrice;
//        private TextView courseRatingNumber;
//        private TextView courseLessonNumber;
//        private TextView courseSectionNumber;
//
//
//        public ViewHolder(@NonNull View itemView) {
//            super(itemView);
//
//            courseImage = itemView.findViewById(R.id.courseImageId);
//            courseTitle = itemView.findViewById(R.id.courseTitleId);
//            courseName = itemView.findViewById(R.id.courseNameId);
//            coursePrice = itemView.findViewById(R.id.coursePriceId);
//            courseRatingNumber=itemView.findViewById(R.id.courseRatingNumberId);
//            courseLessonNumber=itemView.findViewById(R.id.courseLeassonId);
//            courseSectionNumber=itemView.findViewById(R.id.courseSectionId);
//        }
//        private void setCourseImage(int resource){
//            courseImage.setImageResource(resource);
//        }
//        private void setCourseTitle(String title){
//            courseTitle.setText(title);
//        }
//        private void setCourseName(String name){
//            courseName.setText(name);
//        }
//        private void setCoursePrice(String price){
//            coursePrice.setText(price);
//        }
//
//        private void setCourseRating(String rating){
//            courseRatingNumber.setText(rating);
//        }
//        private void setCourseLesson(String lesson){
//            courseLessonNumber.setText(lesson);
//        }
//        private void setCourseSection(String section){
//            courseSectionNumber.setText(section);
//        }
//    }
}

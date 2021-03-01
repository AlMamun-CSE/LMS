package com.techdsf.lms.ui.home;

import android.widget.ImageView;
import android.widget.TextView;

public class Horizontal_Course_Model {

    public static final int HORIZONTAL_LAYOUT = 0;
    public static final int VERTICAL_LAYOUT = 1;

    private int viewType;

    //horizontal layout
    private String lossCoursePrice;

    //vertical layout
    private int courseImage;
    private String courseTitle;
    private String courseName;
    private String coursePrice;
    private String courseRatingNumber;
    private String courseLessonNumber;
    private String courseSectionNumber;

    public Horizontal_Course_Model(int viewType,int courseImage, String courseTitle, String courseName, String coursePrice,String lossCoursePrice
            ,String courseRatingNumber,String courseLessonNumber,String courseSectionNumber) {
        this.viewType = viewType;
        this.courseImage = courseImage;
        this.courseTitle = courseTitle;
        this.courseName = courseName;
        this.coursePrice = coursePrice;
        this.lossCoursePrice = lossCoursePrice;
        this.courseRatingNumber = courseRatingNumber;
        this.courseLessonNumber = courseLessonNumber;
        this.courseSectionNumber = courseSectionNumber;
    }

    public Horizontal_Course_Model(int viewType,int courseImage, String courseTitle, String courseName, String coursePrice
    ,String courseRatingNumber,String courseLessonNumber,String courseSectionNumber) {
        this.viewType = viewType;
        this.courseImage = courseImage;
        this.courseTitle = courseTitle;
        this.courseName = courseName;
        this.coursePrice = coursePrice;
        this.courseRatingNumber = courseRatingNumber;
        this.courseLessonNumber = courseLessonNumber;
        this.courseSectionNumber = courseSectionNumber;
    }

    public int getViewType() {
        return viewType;
    }

    public void setViewType(int viewType) {
        this.viewType = viewType;
    }

    public String getLossCoursePrice() {
        return lossCoursePrice;
    }

    public void setLossCoursePrice(String lossCoursePrice) {
        this.lossCoursePrice = lossCoursePrice;
    }

    public String getCourseRatingNumber() {
        return courseRatingNumber;
    }

    public void setCourseRatingNumber(String courseRatingNumber) {
        this.courseRatingNumber = courseRatingNumber;
    }

    public String getCourseLessonNumber() {
        return courseLessonNumber;
    }

    public void setCourseLessonNumber(String courseLessonNumber) {
        this.courseLessonNumber = courseLessonNumber;
    }

    public String getCourseSectionNumber() {
        return courseSectionNumber;
    }

    public void setCourseSectionNumber(String courseSectionNumber) {
        this.courseSectionNumber = courseSectionNumber;
    }

    public int getCourseImage() {
        return courseImage;
    }

    public void setCourseImage(int courseImage) {
        this.courseImage = courseImage;
    }

    public String getCourseTitle() {
        return courseTitle;
    }

    public void setCourseTitle(String courseTitle) {
        this.courseTitle = courseTitle;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCoursePrice() {
        return coursePrice;
    }

    public void setCoursePrice(String coursePrice) {
        this.coursePrice = coursePrice;
    }
}

package com.techdsf.lms.ui.category;

public class CategoryItemModel {
    private int categoryItemImage;
    private String categoryName;

    public CategoryItemModel(int categoryItemImage, String categoryName) {
        this.categoryItemImage = categoryItemImage;
        this.categoryName = categoryName;
    }

    public int getCategoryItemImage() {
        return categoryItemImage;
    }

    public void setCategoryItemImage(int categoryItemImage) {
        this.categoryItemImage = categoryItemImage;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
}

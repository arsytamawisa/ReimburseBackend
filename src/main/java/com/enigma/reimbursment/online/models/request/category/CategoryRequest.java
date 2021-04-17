package com.enigma.reimbursment.online.models.request.category;

import com.enigma.reimbursment.online.models.validations.alphabetic.Alphabetic;

public class CategoryRequest {

    @Alphabetic
    private String categoryName;

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
}

package com.enigma.reimbursment.online.models.response.category;

public class CategoryResponse {
    private String id;

    private String categoryName;

    public CategoryResponse(String responseId) {
    }

    public CategoryResponse() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
}

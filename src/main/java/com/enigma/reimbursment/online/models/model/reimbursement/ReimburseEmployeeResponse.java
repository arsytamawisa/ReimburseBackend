package com.enigma.reimbursment.online.models.model.reimbursement;

import com.enigma.reimbursment.online.models.response.category.CategoryResponse;
import com.enigma.reimbursment.online.models.response.employee.EmployeeResponse;

import java.util.Date;

public class ReimburseEmployeeResponse {

    private EmployeeResponse employeeId;

    private Date dateOfClaimSubmission;

    private CategoryResponse categoryId;

    private Integer claimFee;

    public EmployeeResponse getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(EmployeeResponse employeeId) {
        this.employeeId = employeeId;
    }

    public Date getDateOfClaimSubmission() {
        return dateOfClaimSubmission;
    }

    public void setDateOfClaimSubmission(Date dateOfClaimSubmission) {
        this.dateOfClaimSubmission = dateOfClaimSubmission;
    }

    public CategoryResponse getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(CategoryResponse categoryId) {
        this.categoryId = categoryId;
    }

    public Integer getClaimFee() {
        return claimFee;
    }

    public void setClaimFee(Integer claimFee) {
        this.claimFee = claimFee;
    }
}

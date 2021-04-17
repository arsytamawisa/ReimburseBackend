package com.enigma.reimbursment.online.models.model.reimbursement;

public class RequestModelEmployee {

    private String employeeId;

    private String dateOfClaimSubmission;

    private String categoryId;

    private Integer claimFee;



    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getDateOfClaimSubmission() {
        return dateOfClaimSubmission;
    }

    public void setDateOfClaimSubmission(String dateOfClaimSubmission) {
        this.dateOfClaimSubmission = dateOfClaimSubmission;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public Integer getClaimFee() {
        return claimFee;
    }

    public void setClaimFee(Integer claimFee) {
        this.claimFee = claimFee;
    }

    @Override
    public String toString() {
        return "ReimbursementModelEmployee{" +
                "employeeId=" + employeeId +
                ", dateOfClaimSubmission=" + dateOfClaimSubmission +
                ", categoryId=" + categoryId +
                ", claimFee=" + claimFee +
                '}';
    }
}

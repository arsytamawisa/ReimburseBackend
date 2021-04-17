package com.enigma.reimbursment.online.models.request.reimbursements;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.validation.constraints.NotBlank;

public class ReimbursementRequestEmployee {
    @JsonFormat(pattern = "yyyy-MM-dd")
    private String dateOfClaimSubmission;
    private Boolean statusReject;
    private Boolean statusOnHc;
    private Boolean statusOnFinance;
    private Boolean statusSuccess;
    @NotBlank
    private String employeeId;
    @NotBlank
    private String categoryId;
    private String startDate;
    private String endDate;


    public String getDateOfClaimSubmission() {
        return dateOfClaimSubmission;
    }

    public void setDateOfClaimSubmission(String dateOfClaimSubmission) {
        this.dateOfClaimSubmission = dateOfClaimSubmission;
    }

    public Boolean getStatusReject() {
        return statusReject;
    }

    public void setStatusReject(Boolean statusReject) {
        this.statusReject = statusReject;
    }

    public Boolean getStatusOnHc() {
        return statusOnHc;
    }

    public void setStatusOnHc(Boolean statusOnHc) {
        this.statusOnHc = statusOnHc;
    }

    public Boolean getStatusOnFinance() {
        return statusOnFinance;
    }

    public void setStatusOnFinance(Boolean statusOnFinance) {
        this.statusOnFinance = statusOnFinance;
    }

    public Boolean getStatusSuccess() {
        return statusSuccess;
    }

    public void setStatusSuccess(Boolean statusSuccess) {
        this.statusSuccess = statusSuccess;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }
}

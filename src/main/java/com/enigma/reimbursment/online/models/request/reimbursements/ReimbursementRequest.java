package com.enigma.reimbursment.online.models.request.reimbursements;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.Date;

public class ReimbursementRequest {

    @JsonFormat(pattern = "yyyy-MM-dd")
    private String dateOfClaimSubmission;
    @Pattern(message = "input number only",regexp = "/^[0-9]+$/")
    private Integer claimFee;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private String disbursementDate;
    private Boolean statusReject;
    private Boolean statusOnHc;
    private Boolean statusOnFinance;
    private Boolean statusSuccess;
    @Pattern(message = "input number only",regexp = "/^[0-9]+$/")
    private Integer borneCost;
    @NotBlank
    private String employeeId;
    @NotBlank
    private String categoryId;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private String startDate;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private String endDate;

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

    public String getDateOfClaimSubmission() {
        return dateOfClaimSubmission;
    }

    public void setDateOfClaimSubmission(String dateOfClaimSubmission) {
        this.dateOfClaimSubmission = dateOfClaimSubmission;
    }

    public Integer getClaimFee() {
        return claimFee;
    }

    public void setClaimFee(Integer claimFee) {
        this.claimFee = claimFee;
    }

    public String getDisbursementDate() {
        return disbursementDate;
    }

    public void setDisbursementDate(String disbursementDate) {
        this.disbursementDate = disbursementDate;
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

    public Integer getBorneCost() {
        return borneCost;
    }

    public void setBorneCost(Integer borneCost) {
        this.borneCost = borneCost;
    }

//    @Override
//    public String toString() {
//        return "ReimbursementRequest{" +
//                "dateOfClaimSubmission='" + dateOfClaimSubmission + '\'' +
//                ", claimFee=" + claimFee +
//                ", disbursementDate='" + disbursementDate + '\'' +
//                ", statusReject=" + statusReject +
//                ", statusOnHc=" + statusOnHc +
//                ", statusOnFinance=" + statusOnFinance +
//                ", statusSuccess=" + statusSuccess +
//                ", borneCost=" + borneCost +
//                ", employeeId='" + employeeId + '\'' +
//                ", categoryId='" + categoryId + '\'' +
//                '}';
//    }
}

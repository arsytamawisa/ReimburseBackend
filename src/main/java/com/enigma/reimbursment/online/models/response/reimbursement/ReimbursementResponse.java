package com.enigma.reimbursment.online.models.response.reimbursement;

import com.enigma.reimbursment.online.models.response.category.CategoryResponse;
import com.enigma.reimbursment.online.models.response.employee.EmployeeResponse;

import java.time.LocalDate;
import java.util.Date;

public class ReimbursementResponse {

    private String id;
    private LocalDate dateOfClaimSubmission;
    private Integer claimFee;
    private LocalDate disbursementDate;
    private Boolean statusReject;
    private Boolean statusOnHc;
    private Boolean statusOnFinance;
    private Boolean statusSuccess;
    private Integer borneCost;
    private EmployeeResponse employeeId;
    private CategoryResponse categoryId;
    private LocalDate startDate;
    private LocalDate endDate;


    public void setDateOfClaimSubmission(LocalDate dateOfClaimSubmission) {
        this.dateOfClaimSubmission = dateOfClaimSubmission;
    }

    public LocalDate getDateOfClaimSubmission() {
        return dateOfClaimSubmission;
    }

    public LocalDate getDisbursementDate() {
        return disbursementDate;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setDisbursementDate(LocalDate disbursementDate) {
        this.disbursementDate = disbursementDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public EmployeeResponse getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(EmployeeResponse employeeId) {
        this.employeeId = employeeId;
    }

    @Override
    public String toString() {
        return "ReimbursementResponse{" +
                "dateOfClaimSubmission=" + dateOfClaimSubmission +
                ", claimFee=" + claimFee +
                ", disbursementDate=" + disbursementDate +
                ", statusReject=" + statusReject +
                ", statusOnHc=" + statusOnHc +
                ", statusOnFinance=" + statusOnFinance +
                ", statusSuccess=" + statusSuccess +
                ", borneCost=" + borneCost +
                ", employeeId=" + employeeId +
                ", categoryId=" + categoryId +
                '}';
    }
}

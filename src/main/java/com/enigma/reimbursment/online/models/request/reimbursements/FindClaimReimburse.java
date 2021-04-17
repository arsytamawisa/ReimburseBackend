package com.enigma.reimbursment.online.models.request.reimbursements;

public class FindClaimReimburse {

    private Integer claimFee;

    private String employeeId;

    private String categoryId;

    private String startDate;

    private String endDate;


    public Integer getClaimFee() {
        return claimFee;
    }

    public void setClaimFee(Integer claimFee) {
        this.claimFee = claimFee;
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


    @Override
    public String toString() {
        return "FindClaimReimburse{" +
                ", claimFee=" + claimFee +
                ", employeeId='" + employeeId + '\'' +
                ", categoryId='" + categoryId + '\'' +
                ", startDate='" + startDate + '\'' +
                ", endDate='" + endDate + '\'' +
                '}';
    }
}

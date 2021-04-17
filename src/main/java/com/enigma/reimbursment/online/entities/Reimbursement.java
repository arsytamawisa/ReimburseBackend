package com.enigma.reimbursment.online.entities;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.NumberFormat;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table
public class Reimbursement extends AbstractEntity<String> {
    @Id
    @GenericGenerator(name = "id_reimbursement", strategy = "uuid2")
    @GeneratedValue(generator = "id_reimbursement", strategy = GenerationType.IDENTITY)
    private String id;

    @Column(name = "date_of_claim_submission")
    private LocalDate dateOfClaimSubmission;

    @Column(name = "claim_fee")
    private Integer claimFee;
    @Column(name = "disbursement_date")
    private LocalDate disbursementDate;
    @Column(name = "status_reject")
    private Boolean statusReject = false;
    @Column(name = "status_on_hc")
    private Boolean statusOnHc = false;
    @Column(name = "status_on_finance")
    private Boolean statusOnFinance = false;
    @Column(name = "status_success")
    private Boolean statusSuccess = false;
    @Column(name = "borne_cost") //Merupakan biaya yang ditanggung
    private Integer borneCost;

    @ManyToOne
    @JoinColumn(name = "id_employee")
    private Employee employeeId;

    @ManyToOne
    @JoinColumn(name = "id_category")
    private Category categoryId;

    @Column(name = "start_date")
    private LocalDate startDate;

    @Column(name = "end_date")
    private LocalDate endDate;

    public Reimbursement(String id) {
        this.id = id;
    }

    public Reimbursement() {
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
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

    public Category getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Category categoryId) {
        this.categoryId = categoryId;
    }

    public LocalDate getDateOfClaimSubmission() {
        return dateOfClaimSubmission;
    }

    public void setDateOfClaimSubmission(LocalDate dateOfClaimSumbission) {
        this.dateOfClaimSubmission = dateOfClaimSumbission;
    }

    public Integer getClaimFee() {
        return claimFee;
    }

    public void setClaimFee(Integer claimFee) {
        this.claimFee = claimFee;
    }

    public LocalDate getDisbursementDate() {
        return disbursementDate;
    }

    public void setDisbursementDate(LocalDate disbursmentDate) {
        this.disbursementDate = disbursmentDate;
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

    public Employee getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Employee employeeId) {
        this.employeeId = employeeId;
    }


    @Override
    public String toString() {
        return "Reimbursement{" +
                "id='" + id + '\'' +
                ", dateOfClaimSubmission=" + dateOfClaimSubmission +
                ", claimFee=" + claimFee +
                ", disbursementDate=" + disbursementDate +
                ", statusReject=" + statusReject +
                ", statusOnHc=" + statusOnHc +
                ", statusOnFinance=" + statusOnFinance +
                ", statusSuccess=" + statusSuccess +
                ", borneCost=" + borneCost +
                ", employeeId=" + employeeId +
                ", categoryId=" + categoryId +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                '}';
    }
}

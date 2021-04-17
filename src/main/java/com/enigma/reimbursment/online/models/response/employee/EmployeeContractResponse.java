package com.enigma.reimbursment.online.models.response.employee;


import java.time.LocalDate;
import java.util.Date;

public class EmployeeContractResponse {

    private String id;

    private EmployeeResponse employeeId;

    private String typeContract;

    private String benefitRegistrationStatus;

    private LocalDate startDateContract;

    private LocalDate endDateContract;

    private Boolean isEndedContract = false;

    private LocalDate dateOfAcceptancePermanentEmployee;

    private LocalDate dateOfResignation;

    private String placement;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public EmployeeResponse getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(EmployeeResponse employeeId) {
        this.employeeId = employeeId;
    }

    public String getTypeContract() {
        return typeContract;
    }

    public void setTypeContract(String typeContract) {
        this.typeContract = typeContract;
    }

    public String getBenefitRegistrationStatus() {
        return benefitRegistrationStatus;
    }

    public void setBenefitRegistrationStatus(String benefitRegistrationStatus) {
        this.benefitRegistrationStatus = benefitRegistrationStatus;
    }

    public LocalDate getStartDateContract() {
        return startDateContract;
    }

    public void setStartDateContract(LocalDate startDateContract) {
        this.startDateContract = startDateContract;
    }

    public LocalDate getEndDateContract() {
        return endDateContract;
    }

    public void setEndDateContract(LocalDate endDateContract) {
        this.endDateContract = endDateContract;
    }

    public Boolean getEndedContract() {
        return isEndedContract;
    }

    public void setEndedContract(Boolean endedContract) {
        isEndedContract = endedContract;
    }

    public LocalDate getDateOfAcceptancePermanentEmployee() {
        return dateOfAcceptancePermanentEmployee;
    }

    public void setDateOfAcceptancePermanentEmployee(LocalDate dateOfAcceptancePermanentEmployee) {
        this.dateOfAcceptancePermanentEmployee = dateOfAcceptancePermanentEmployee;
    }

    public LocalDate getDateOfResignation() {
        return dateOfResignation;
    }

    public void setDateOfResignation(LocalDate dateOfResignation) {
        this.dateOfResignation = dateOfResignation;
    }

    public String getPlacement() {
        return placement;
    }

    public void setPlacement(String placement) {
        this.placement = placement;
    }


}

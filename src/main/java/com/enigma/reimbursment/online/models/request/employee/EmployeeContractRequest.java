package com.enigma.reimbursment.online.models.request.employee;

import com.enigma.reimbursment.online.enums.StatusRegistrationBenefit;
import com.enigma.reimbursment.online.enums.TypeOfContract;

public class EmployeeContractRequest {


    private String employeeId;

    private TypeOfContract typeContract;

    private StatusRegistrationBenefit benefitRegistrationStatus;

    private String startDateContract;

    private String endDateContract;

    private Boolean isEndedContract;

    private String dateOfAcceptancePermanentEmployee;

    private String dateOfResignation;

    private String placement;

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public TypeOfContract getTypeContract() {
        return typeContract;
    }

    public void setTypeContract(TypeOfContract typeContract) {
        this.typeContract = typeContract;
    }

    public StatusRegistrationBenefit getBenefitRegistrationStatus() {
        return benefitRegistrationStatus;
    }

    public void setBenefitRegistrationStatus(StatusRegistrationBenefit benefitRegistrationStatus) {
        this.benefitRegistrationStatus = benefitRegistrationStatus;
    }

    public String getStartDateContract() {
        return startDateContract;
    }

    public void setStartDateContract(String startDateContract) {
        this.startDateContract = startDateContract;
    }

    public String getEndDateContract() {
        return endDateContract;
    }

    public void setEndDateContract(String endDateContract) {
        this.endDateContract = endDateContract;
    }

    public Boolean getEndedContract() {
        return isEndedContract;
    }

    public void setEndedContract(Boolean endedContract) {
        isEndedContract = endedContract;
    }

    public String getDateOfAcceptancePermanentEmployee() {
        return dateOfAcceptancePermanentEmployee;
    }

    public void setDateOfAcceptancePermanentEmployee(String dateOfAcceptancePermanentEmployee) {
        this.dateOfAcceptancePermanentEmployee = dateOfAcceptancePermanentEmployee;
    }

    public String getDateOfResignation() {
        return dateOfResignation;
    }

    public void setDateOfResignation(String dateOfResignation) {
        this.dateOfResignation = dateOfResignation;
    }

    public String getPlacement() {
        return placement;
    }

    public void setPlacement(String placement) {
        this.placement = placement;
    }

    @Override
    public String toString() {
        return "EmployeeContractRequest{" +
                "employeeId='" + employeeId + '\'' +
                ", typeContract=" + typeContract +
                ", benefitRegistrationStatus=" + benefitRegistrationStatus +
                ", startDateContract='" + startDateContract + '\'' +
                ", endDateContract='" + endDateContract + '\'' +
                ", isEndedContract=" + isEndedContract +
                ", dateOfAcceptancePermanentEmployee='" + dateOfAcceptancePermanentEmployee + '\'' +
                ", dateOfResignation='" + dateOfResignation + '\'' +
                ", placement='" + placement + '\'' +
                '}';
    }
}

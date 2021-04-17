package com.enigma.reimbursment.online.entities;

import com.enigma.reimbursment.online.enums.StatusRegistrationBenefit;
import com.enigma.reimbursment.online.enums.TypeOfContract;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Table(name = "employee_contract")
@Entity
public class EmployeeContract extends AbstractEntity <String> {

    @Id
    @GenericGenerator(name="id",strategy = "uuid2")
    @GeneratedValue(generator = "id",strategy = GenerationType.IDENTITY)
    private String id;

    @OneToOne
    @JoinColumn(name = "employee_id")
    private Employee employeeId;

    @Enumerated(EnumType.STRING)
    @Column(name = "type_contract")
    private TypeOfContract typeContract;

    @Enumerated(EnumType.STRING)
    @Column(name = "benefit_registration_status")
    private StatusRegistrationBenefit benefitRegistrationStatus;

    @Column(name = "start_date_contract")
    private LocalDate startDateContract;

    @Column(name = "end_date_contract")
    private LocalDate endDateContract;

    @Column(name = "is_ended_contract")
    private Boolean isEndedContract = false;

    @Column(name = "date_of_acceptance_permanent_employee")
    private LocalDate dateOfAcceptancePermanentEmployee;

    @Column(name = "date_of_resignation")
    private LocalDate dateOfResignation;

    @Column(name = "placement")
    private String placement;

    public EmployeeContract(String id) {
        this.id = id;
    }

    public EmployeeContract() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Employee getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Employee employeeId) {
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

    @Override
    public String toString() {
        return "EmployeeContract{" +
                "id='" + id + '\'' +
                ", employeeId=" + employeeId +
                ", typeContract=" + typeContract +
                ", benefitRegistrationStatus=" + benefitRegistrationStatus +
                ", startDateContract=" + startDateContract +
                ", endDateContract=" + endDateContract +
                ", isEndedContract=" + isEndedContract +
                ", dateOfAcceptancePermanentEmployee=" + dateOfAcceptancePermanentEmployee +
                ", dateOfResignation=" + dateOfResignation +
                ", placement='" + placement + '\'' +
                '}';
    }
}

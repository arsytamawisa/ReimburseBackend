package com.enigma.reimbursment.online.models.request.employee;

import com.enigma.reimbursment.online.enums.EmployeeStatus;
import com.enigma.reimbursment.online.enums.EmployeeType;

import java.time.LocalDate;

public class EmployeeRequest {

   private Integer gradeId;

   private String joinDate;

   private EmployeeStatus employeeStatus;

   private EmployeeType employeeType;

   private String nip;

    public String getNip() {
        return nip;
    }

    public void setNip(String nip) {
        this.nip = nip;
    }

    public Integer getGradeId() {
        return gradeId;
    }

    public void setGradeId(Integer gradeId) {
        this.gradeId = gradeId;
    }

    public String getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(String joinDate) {
        this.joinDate = joinDate;
    }

    public EmployeeStatus getEmployeeStatus() {
        return employeeStatus;
    }

    public void setEmployeeStatus(EmployeeStatus employeeStatus) {
        this.employeeStatus = employeeStatus;
    }

    public EmployeeType getEmployeeType() {
        return employeeType;
    }

    public void setEmployeeType(EmployeeType employeeType) {
        this.employeeType = employeeType;
    }
}

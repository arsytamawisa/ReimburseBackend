package com.enigma.reimbursment.online.enums;

public enum EmployeeType {
    OFFICE,ONSITE;

    private static final EmployeeType[] employeeTypeList = EmployeeType.values();

    public static EmployeeType getEmployeeType(int i) {
        return employeeTypeList[i];
    }
}

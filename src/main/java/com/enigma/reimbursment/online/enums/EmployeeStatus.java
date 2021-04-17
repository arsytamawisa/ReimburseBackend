package com.enigma.reimbursment.online.enums;

public enum EmployeeStatus {
    ACTIVE,NON_ACTIVE;

    private static final EmployeeStatus[] employeeStatusList = EmployeeStatus.values();

    public static EmployeeStatus getEmployeeStatus(int i) {
        return employeeStatusList[i];
    }
}

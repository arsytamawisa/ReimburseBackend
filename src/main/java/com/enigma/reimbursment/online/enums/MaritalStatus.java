package com.enigma.reimbursment.online.enums;

public enum MaritalStatus {
    MARRIED,SINGLE,DIVORCE;

    private static final MaritalStatus[] maritalStatusList = MaritalStatus.values();

    public static MaritalStatus getMaritalStatus(int i) {
        return maritalStatusList[i];
    }
}

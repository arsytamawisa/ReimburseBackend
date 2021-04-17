package com.enigma.reimbursment.online.enums;

public enum TypeOfContract {
    PROBABITION, PKWT;

    private static final TypeOfContract[] employeeTypeList = TypeOfContract.values();

    public static TypeOfContract getTypeOfContract(int i) {
        return employeeTypeList[i];
    }

}

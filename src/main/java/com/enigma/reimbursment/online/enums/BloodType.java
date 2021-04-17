package com.enigma.reimbursment.online.enums;

public enum BloodType {
    A,B,O,AB;

    private static final BloodType[] bloodTypeList = BloodType.values();

    public static BloodType getBloodType(int i) {
        return bloodTypeList[i];
    }
}

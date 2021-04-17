package com.enigma.reimbursment.online.enums;

public enum Gender {
    MALE, FEMALE;

    private static final Gender[] genderList = Gender.values();

    public static Gender getGender(int i) {
        return genderList[i];
    }
}

package com.enigma.reimbursment.online.enums;

public enum Religion {
    ISLAM, PROTESTAN,KATOLIK,BUDDHA,HINDU, KONGHUCU;

    private static final Religion[] religionList = Religion.values();

    public static Religion getReligion(int i) {
        return religionList[i];
    }
}

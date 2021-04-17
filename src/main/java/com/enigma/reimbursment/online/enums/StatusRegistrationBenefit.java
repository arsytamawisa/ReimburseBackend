package com.enigma.reimbursment.online.enums;

public enum StatusRegistrationBenefit {
    ON_PROCESS,DONE;

    private static final StatusRegistrationBenefit[] statusRegistrationBenefitList = StatusRegistrationBenefit.values();

    public static StatusRegistrationBenefit getStatusRegistrationBenefit(int i) {
        return statusRegistrationBenefitList[i];
    }
}

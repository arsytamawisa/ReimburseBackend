package com.enigma.reimbursment.online.models.model.reimbursement;

public class ReimbursementModelHc {

    private Boolean statusReject;

    private Boolean statusOnHc;

    private Boolean statusOnFinance;

    public Boolean getStatusReject() {
        return statusReject;
    }

    public void setStatusReject(Boolean statusReject) {
        this.statusReject = statusReject;
    }

    public Boolean getStatusOnHc() {
        return statusOnHc;
    }

    public void setStatusOnHc(Boolean statusOnHc) {
        this.statusOnHc = statusOnHc;

    }

    public Boolean getStatusOnFinance() {
        return statusOnFinance;
    }

    public void setStatusOnFinance(Boolean statusOnFinance) {
        this.statusOnFinance = statusOnFinance;
    }

    @Override
    public String toString() {
        return "ReimbursementModelHc{" +
                "statusReject=" + statusReject +
                ", statusOnHc=" + statusOnHc +
                ", statusOnFinance=" + statusOnFinance +
                '}';
    }
}
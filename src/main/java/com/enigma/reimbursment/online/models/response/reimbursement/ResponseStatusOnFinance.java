package com.enigma.reimbursment.online.models.response.reimbursement;

public class ResponseStatusOnFinance {

    private String id;

    private Boolean statusOnFinance = false;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Boolean getStatusOnFinance() {
        return statusOnFinance;
    }

    public void setStatusOnFinance(Boolean statusOnFinance) {
        this.statusOnFinance = statusOnFinance;
    }
}

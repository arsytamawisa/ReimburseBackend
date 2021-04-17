package com.enigma.reimbursment.online.models.response.reimbursement;

public class ResponseStatusOnHc {

    private String id;

    private Boolean statusOnHc = false;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Boolean getStatusOnHc() {
        return statusOnHc;
    }

    public void setStatusOnHc(Boolean statusOnHc) {
        this.statusOnHc = statusOnHc;
    }
}

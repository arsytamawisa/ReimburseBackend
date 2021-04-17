package com.enigma.reimbursment.online.models.request.reimbursements.claim;

import javax.persistence.Column;

public class RequestStatusReject {


    private Boolean statusReject = false;

    public Boolean getStatusReject() {
        return statusReject;
    }

    public void setStatusReject(Boolean statusReject) {
        this.statusReject = statusReject;
    }
}

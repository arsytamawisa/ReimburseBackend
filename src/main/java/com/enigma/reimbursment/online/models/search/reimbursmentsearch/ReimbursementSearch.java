package com.enigma.reimbursment.online.models.search.reimbursmentsearch;

import com.enigma.reimbursment.online.models.pagination.PageSearch;

public class ReimbursementSearch extends PageSearch {

    private Integer claimFee;


    public Integer getClaimFee() {
        return claimFee;
    }

    public void setClaimFee(Integer claimFee) {
        this.claimFee = claimFee;
    }

    @Override
    public String toString() {
        return "ReimbursementSearch{" +
                "claimFee=" + claimFee +
                '}';
    }
}

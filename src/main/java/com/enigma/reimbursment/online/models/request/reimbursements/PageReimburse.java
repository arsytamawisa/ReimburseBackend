package com.enigma.reimbursment.online.models.request.reimbursements;

import com.enigma.reimbursment.online.models.pagination.PageSearch;
import org.springframework.data.domain.Sort;

import javax.validation.constraints.Max;

public class PageReimburse extends PageSearch {
    private Integer offSet = 0;

    public Integer getOffSet() {
        return offSet;
    }

    public void setOffSet(Integer offSet) {
        this.offSet = offSet;
    }
}

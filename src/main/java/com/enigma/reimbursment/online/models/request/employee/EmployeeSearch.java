package com.enigma.reimbursment.online.models.request.employee;


import com.enigma.reimbursment.online.models.pagination.PageSearch;

public class EmployeeSearch extends PageSearch {

    private String fullname;

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }
}

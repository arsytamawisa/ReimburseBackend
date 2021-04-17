package com.enigma.reimbursment.online.models.request.employee;

public class EmployeeRequestChangePassword {

    private String idLogin;
    private String password;

    public String getIdLogin() {
        return idLogin;
    }

    public void setIdLogin(String idLogin) {
        this.idLogin = idLogin;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

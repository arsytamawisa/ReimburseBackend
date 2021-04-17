package com.enigma.reimbursment.online.models.request.register;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class RegisterEmployeeRequest {

    @NotBlank
    private String email;

    @Size(min = 8, max = 50)
    private String password;


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    @Override
    public String toString() {
        return "RegisterEmployeeRequest{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}

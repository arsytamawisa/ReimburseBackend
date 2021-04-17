package com.enigma.reimbursment.online.models.response.login;


import com.enigma.reimbursment.online.entities.Role;

public class LoginResponse {

    private String id;
    private String email;
    private Role role;


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "LoginResponse{" +
                "id='" + id + '\'' +
                ", email='" + email + '\'' +
                ", role=" + role +
                '}';
    }
}

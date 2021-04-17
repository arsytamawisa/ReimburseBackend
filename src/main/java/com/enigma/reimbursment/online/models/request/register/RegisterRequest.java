package com.enigma.reimbursment.online.models.request.register;

import com.enigma.reimbursment.online.entities.Role;
import com.enigma.reimbursment.online.models.validations.alphabetic.Alphabetic;

public class RegisterRequest {
    private String name;

    private String username;

    private String password;

    private Role role;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "LoginRequest{" +
                "Username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", role=" + role +
                '}';
    }
}

package com.enigma.reimbursment.online.models.request.register;


public class RegisterAdminRequest {

    private String email;
    private String password;
    private Integer roleId;
    private String name;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

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

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    @Override
    public String toString() {
        return "RegisterAdminRequest{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", roleId='" + roleId + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}

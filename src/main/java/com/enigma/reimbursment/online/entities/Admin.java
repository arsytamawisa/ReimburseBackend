package com.enigma.reimbursment.online.entities;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Table(name = "admin")
@Entity
public class Admin{
    @Id
    @GenericGenerator(name = "id_admin", strategy = "uuid2")
    @GeneratedValue(generator = "id_admin", strategy = GenerationType.IDENTITY)
    private String id;

    private String name;

    @OneToOne
    @JoinColumn(name = "id_login")
    private Login login;

    public Admin(String id) {
        this.id = id;
    }

    public Admin() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Login getLogin() {
        return login;
    }

    public void setLogin(Login login) {
        this.login = login;
    }
}

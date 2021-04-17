package com.enigma.reimbursment.online.entities;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Table
@Entity
public class Login extends AbstractEntity<String>{
    @Id
    @GenericGenerator(name="id_login",strategy = "uuid2")
    @GeneratedValue(generator = "id_login",strategy = GenerationType.IDENTITY)
    private String id;

    @Column(unique=true)
    private String email;

    private String password;

    @OneToOne
    @JoinColumn(name = "id_role")
    private Role role;



    /* Getter & Setter */

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
}

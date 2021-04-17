package com.enigma.reimbursment.online.entities;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table
public class Category {

    @Id
    @GenericGenerator(name="id_category",strategy = "uuid2")
    @GeneratedValue(generator = "id_category",strategy = GenerationType.IDENTITY)
    private String id;


    private String categoryName;

    public Category(String id) {
        this.id = id;
    }

    public Category() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
}

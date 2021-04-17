package com.enigma.reimbursment.online.entities;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table
public class Grade {

    @Id
    @GenericGenerator(name="id",strategy = "uuid2")
    @GeneratedValue(generator = "id",strategy = GenerationType.IDENTITY)
    private String id;
    @Column(name = "grade")
    private Integer grade;
    @Column(name = "glasess_cost")
    private Integer glasessCost;
    @Column(name = "give_birth_cost")
    private Integer giveBirthCost;
    @Column(name = "transportation_cost")
    private Integer transportationCost;
    @Column(name = "training_cost") //Merupakan biaya yang ditanggung
    private Integer trainingCost;
    @Column(name = "official_travel_cost") //Merupakan biaya yang ditanggung
    private Integer officialTravelCost;
    @Column(name = "insurance_cost") //Merupakan biaya yang ditanggung
    private Integer insuranceCost;



    public Grade(String id) {
        this.id = id;
    }

    public Grade() {
    }

    public Integer getTrainingCost() {
        return trainingCost;
    }

    public void setTrainingCost(Integer trainingCost) {
        this.trainingCost = trainingCost;
    }

    public Integer getOfficialTravelCost() {
        return officialTravelCost;
    }

    public void setOfficialTravelCost(Integer officialTravelCost) {
        this.officialTravelCost = officialTravelCost;
    }

    public Integer getInsuranceCost() {
        return insuranceCost;
    }

    public void setInsuranceCost(Integer insuranceCost) {
        this.insuranceCost = insuranceCost;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer numgrade) {
        this.grade = numgrade;
    }

    public Integer getGlasessCost() {
        return glasessCost;
    }

    public void setGlasessCost(Integer glasessCost) {
        this.glasessCost = glasessCost;
    }

    public Integer getGiveBirthCost() {
        return giveBirthCost;
    }

    public void setGiveBirthCost(Integer giveBirthCost) {
        this.giveBirthCost = giveBirthCost;
    }

    public Integer getTransportationCost() {
        return transportationCost;
    }

    public void setTransportationCost(Integer transportationCost) {
        this.transportationCost = transportationCost;
    }
}

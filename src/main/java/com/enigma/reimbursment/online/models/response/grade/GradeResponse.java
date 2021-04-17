package com.enigma.reimbursment.online.models.response.grade;

import javax.persistence.Column;

public class GradeResponse {

    private String id;

    private Integer grade;

    private Integer glasessCost;

    private Integer giveBirthCost;

    private Integer transportationCost;

    private Integer trainingCost;

    private Integer officialTravelCost;

    private Integer insuranceCost;

    public GradeResponse(String id) {
        this.id = id;
    }

    public GradeResponse() {
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

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "GradeResponse{" +
                "id='" + id + '\'' +
                ", grade=" + grade +
                ", glasessCost=" + glasessCost +
                ", giveBirthCost=" + giveBirthCost +
                ", transportationCost=" + transportationCost +
                ", trainingCost=" + trainingCost +
                ", officialTravelCost=" + officialTravelCost +
                ", insuranceCost=" + insuranceCost +
                '}';
    }
}

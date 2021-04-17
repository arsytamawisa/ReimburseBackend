package com.enigma.reimbursment.online.models.request.grade;

import javax.validation.constraints.Min;
import javax.validation.constraints.Positive;

public class GradeRequest {

    private Integer grade;

    @Min(1)
    private Integer glasessCost;

    @Positive
    private Integer giveBirthCost;

    @Positive
    private Integer transportationCost;

    @Positive
    private Integer trainingCost;

    @Positive
    private Integer officialTravelCost;

    @Positive
    private Integer insuranceCost;

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
}

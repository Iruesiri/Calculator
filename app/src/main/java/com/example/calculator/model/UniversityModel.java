package com.example.calculator.model;

/**
 * @author .: Ossai Michael
 * @email ..: mikeossaiofficial@gmail.com, michael.ossai@cwg-plc.com
 * @created : 20/01/2021 14:21
 */
public class UniversityModel {
    private String universityName;
    private String universityState;
    private String universityType;

    public UniversityModel(String universityName, String universityState, String universityType) {
        this.universityName = universityName;
        this.universityState = universityState;
        this.universityType = universityType;
    }

    public String getUniversityName() {
        return universityName;
    }

    public void setUniversityName(String universityName) {
        this.universityName = universityName;
    }

    public String getUniversityState() {
        return universityState;
    }

    public void setUniversityState(String universityState) {
        this.universityState = universityState;
    }

    public String getUniversityType() {
        return universityType;
    }

    public void setUniversityType(String universityType) {
        this.universityType = universityType;
    }
}

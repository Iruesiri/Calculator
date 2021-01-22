package com.example.calculator.model;

public class UniversityModel {
    //String universityName; String universityState; String universityType;
    private String universityName;
    private String universityState;
    public String universityType;

     public UniversityModel(String universityName, String universityState, String universityType){
        this.universityName = universityName;
        this.universityState = universityState;
        this.universityType = universityType;
    }
    public String getUniversityName(){
         return universityName;
    }
    public void setUniversityName(String universityName){
         this.universityName = universityName;
    }
    public String getUniversityState(){
         return universityState;
    }
    public void setUniversityState(String universityState){
         this.universityState = universityState;
    }
}

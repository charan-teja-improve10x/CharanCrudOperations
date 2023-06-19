package com.example.charancrudopetrations.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class User implements Serializable {

    @SerializedName("_id")
    private String id;
    private String name;
    private Integer age;
    @SerializedName("job")
    private String designation;
    @SerializedName("incomeUSD")
    private Integer incomeUsd;
    private Integer creditScore;
    private String ccNumber;
    private Boolean married;
    private Boolean hasChildren;
    @SerializedName("height")
    private Integer heightInCm;
    @SerializedName("weight")
    private Float weightInKgs;
    private String eyeColor;
    private String email;
    private String gender;
    private Boolean hasDegree;
    private String bloodType;
    private String username;
    private Float politicalLeaning;
    private String religion;
    private Address address;
    @SerializedName("doB")
    private String dateOfBirth;
    private Float gpa;

    public User() {
    }

    public User(String id, String name, Integer age, String designation, Integer incomeUsd,
                Integer creditScore, String ccNumber, Boolean married, Boolean hasChildren, Integer heightInCm,
                Float weightInKgs, String eyeColor, String email, String gender, Boolean hasDegree,
                String bloodType, String username, Float politicalLeaning, String religion, Address address,
                String dateOfBirth, Float gpa){
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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public Integer getIncomeUsd() {
        return incomeUsd;
    }

    public void setIncomeUsd(Integer incomeUsd) {
        this.incomeUsd = incomeUsd;
    }

    public Integer getCreditScore() {
        return creditScore;
    }

    public void setCreditScore(Integer creditScore) {
        this.creditScore = creditScore;
    }

    public String getCcNumber() {
        return ccNumber;
    }

    public void setCcNumber(String ccNumber) {
        this.ccNumber = ccNumber;
    }

    public Boolean getMarried() {
        return married;
    }

    public void setMarried(Boolean married) {
        this.married = married;
    }

    public Boolean getHasChildren() {
        return hasChildren;
    }

    public void setHasChildren(Boolean hasChildren) {
        this.hasChildren = hasChildren;
    }

    public Integer getHeightInCm() {
        return heightInCm;
    }

    public void setHeightInCm(Integer heightInCm) {
        this.heightInCm = heightInCm;
    }

    public Float getWeightInKgs() {
        return weightInKgs;
    }

    public void setWeightInKgs(Float weightInKgs) {
        this.weightInKgs = weightInKgs;
    }

    public String getEyeColor() {
        return eyeColor;
    }

    public void setEyeColor(String eyeColor) {
        this.eyeColor = eyeColor;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Boolean getHasDegree() {
        return hasDegree;
    }

    public void setHasDegree(Boolean hasDegree) {
        this.hasDegree = hasDegree;
    }

    public String getBloodType() {
        return bloodType;
    }

    public void setBloodType(String bloodType) {
        this.bloodType = bloodType;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Float getPoliticalLeaning() {
        return politicalLeaning;
    }

    public void setPoliticalLeaning(Float politicalLeaning) {
        this.politicalLeaning = politicalLeaning;
    }

    public String getReligion() {
        return religion;
    }

    public void setReligion(String religion) {
        this.religion = religion;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Float getGpa() {
        return gpa;
    }

    public void setGpa(Float gpa) {
        this.gpa = gpa;
    }
}




package com.example.student_management_system;

public class Student {

    private int rollNum;
    private String name;
    private String collageName;
    private String city;
    private double percentage;

    // Default constructor
    public Student() {
    }

    // Constructor with roll number
    public Student(int rollNum) {
        this.rollNum = rollNum;
    }

    // Constructor with all fields (except rollNum)
    public Student(String name, String collageName, String city, double percentage) {
        this.name = name;
        this.collageName = collageName;
        this.city = city;
        this.percentage = percentage;
    }

    // Constructor with name only
    public Student(String name) {
        this.name = name;
    }

    // Getters and setters
    public int getRollNum() {
        return rollNum;
    }

    public void setRollNum(int rollNum) {
        this.rollNum = rollNum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCollageName() {
        return collageName;
    }

    public void setCollageName(String collageName) {
        this.collageName = collageName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public double getPercentage() {
        return percentage;
    }

    public void setPercentage(double percentage) {
        this.percentage = percentage;
    }

    @Override
    public String toString() {
        return "Student{" +
                "rollNum=" + rollNum +
                ", name='" + name + '\'' +
                ", collageName='" + collageName + '\'' +
                ", city='" + city + '\'' +
                ", percentage=" + percentage +
                '}';
    }
}


    // Constructors, getters, and setters



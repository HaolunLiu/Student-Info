package com.student.student.entity;

import jakarta.persistence.*;

@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String name;

    private double weight;
    private double height;
    private String hairColor;
    private double gpa;
    private String major;
    public Student(){
    }

    public Student(String name, double weight, double height, String hairColor, double gpa, String major){
        this.name = name;
        this.weight = weight;
        this.height = height;
        this.hairColor = hairColor;
        this.gpa = gpa;
        this.major = major;
    }

    public Long getId(){
        return id;
    }

    public String getName(){
        return name;
    }

    public double getWeight(){
        return weight;
    }

    public double getHeight(){
        return height;
    }

    public String getHairColor(){
        return hairColor;
    }

    public double getGpa(){
        return gpa;
    }

    public void setId(Long id){
        this.id = id;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setWeight(double weight){
        this.weight = weight;
    }

    public void setHeight(double height){
        this.height = height;
    }

    public void setHairColor(String hairColor){
        this.hairColor = hairColor;
    }

    public void setGpa(double gpa){
        this.gpa = gpa;
    }
    public String getMajor(){
        return major;
    }

    public void setMajor(String major){
        this.major = major;
    }
}

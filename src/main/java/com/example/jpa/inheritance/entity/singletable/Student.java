package com.example.jpa.inheritance.entity.singletable;


import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value="S")
public class Student extends Person{

    @Column
    private String course;

    public Student(String course, int fees) {
        this.course = course;
        this.fees = fees;
    }

    public Student(int id, String name, String course, int fees) {
        super(id, name);
        this.course = course;
        this.fees = fees;
    }

    @Column
    private int fees;

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public int getFees() {
        return fees;
    }

    public void setFees(int fees) {
        this.fees = fees;
    }
}

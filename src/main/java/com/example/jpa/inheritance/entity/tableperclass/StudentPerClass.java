package com.example.jpa.inheritance.entity.tableperclass;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="StudentPerClass")
public class StudentPerClass extends PersonPerClass {

    @Column
    private String course;

    public StudentPerClass(String course, int fees) {
        this.course = course;
        this.fees = fees;
    }

    public StudentPerClass(int id, String name, String course, int fees) {
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

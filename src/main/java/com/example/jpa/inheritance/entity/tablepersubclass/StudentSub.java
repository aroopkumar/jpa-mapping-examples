package com.example.jpa.inheritance.entity.tablepersubclass;


import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="StudentSub")
public class StudentSub extends PersonSub {

    @Column
    private String course;

    public StudentSub(String course, int fees) {
        this.course = course;
        this.fees = fees;
    }

    public StudentSub(int id, String name, String course, int fees) {
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

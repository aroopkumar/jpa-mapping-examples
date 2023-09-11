package com.example.jpa.inheritance.entity.tablepersubclass;


import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="TrainerSub")
public class TrainerSub extends PersonSub {

    private  float experience;
    private int salary;

    public TrainerSub(float experience, int salary) {
        this.experience = experience;
        this.salary = salary;
    }

    public TrainerSub(int id, String name, float experience, int salary) {
        super(id, name);
        this.experience = experience;
        this.salary = salary;
    }

    public float getExperience() {
        return experience;
    }

    public void setExperience(float experience) {
        this.experience = experience;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
}

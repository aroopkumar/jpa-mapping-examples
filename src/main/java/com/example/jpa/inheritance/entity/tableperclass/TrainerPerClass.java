package com.example.jpa.inheritance.entity.tableperclass;


import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="TrainerPerClass")
public class TrainerPerClass extends PersonPerClass {

    private  float experience;
    private int salary;

    public TrainerPerClass(float experience, int salary) {
        this.experience = experience;
        this.salary = salary;
    }

    public TrainerPerClass(int id, String name, float experience, int salary) {
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

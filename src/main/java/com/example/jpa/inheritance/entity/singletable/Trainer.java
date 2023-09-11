package com.example.jpa.inheritance.entity.singletable;


import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value="T")
public class Trainer extends Person{

    private  float experience;
    private int salary;

    public Trainer(float experience, int salary) {
        this.experience = experience;
        this.salary = salary;
    }

    public Trainer(int id, String name, float experience, int salary) {
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

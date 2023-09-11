package com.example.jpa.inheritance.entity.singletable;


import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "PersonType", discriminatorType = DiscriminatorType.STRING)
@DiscriminatorValue(value="P")
public class Person {

    @Id
    private int id;

    @Column
    private String name;

    public Person(){
        super();
    }
    public Person(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

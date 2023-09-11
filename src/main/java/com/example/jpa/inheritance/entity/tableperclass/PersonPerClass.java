package com.example.jpa.inheritance.entity.tableperclass;


import javax.persistence.*;

@Entity
@Table(name = "PersonPerClass")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class PersonPerClass {

    @Id
    private int id;

    @Column
    private String name;

    public PersonPerClass(){
        super();
    }
    public PersonPerClass(int id, String name) {
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

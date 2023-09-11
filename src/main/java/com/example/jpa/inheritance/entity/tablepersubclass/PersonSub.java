package com.example.jpa.inheritance.entity.tablepersubclass;


import javax.persistence.*;

@Entity
@Table(name = "PersonSub")
@Inheritance(strategy = InheritanceType.JOINED)
public class PersonSub {

    @Id
    private int id;

    @Column
    private String name;

    public PersonSub(){
        super();
    }
    public PersonSub(int id, String name) {
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

package com.example.jpa.association.entity.onetoone;


import javax.persistence.*;

@Entity
@Table(name="one_to_one_employee")
public class EmployeeOneToOne {

    @Id
    private String id;

    @Column
    private String name;

    @OneToOne(cascade = CascadeType.REMOVE)
    //@OneToOne
    private ParkingSpace parking;

    public ParkingSpace getParking() {
        return parking;
    }

    public void setParking(ParkingSpace parking) {
        this.parking = parking;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

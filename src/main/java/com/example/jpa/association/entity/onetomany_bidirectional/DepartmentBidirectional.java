package com.example.jpa.association.entity.onetomany_bidirectional;


import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="one_to_many_bid_department")
public class DepartmentBidirectional {

    @Id
    private String id;

    @Column
    private String name;

    @OneToMany(targetEntity = EmployeeOneToManyBidirectional.class, cascade = CascadeType.ALL)
    private Set<EmployeeOneToManyBidirectional> employees;

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

    public Set<EmployeeOneToManyBidirectional> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<EmployeeOneToManyBidirectional> employees) {
        this.employees = employees;
    }
}

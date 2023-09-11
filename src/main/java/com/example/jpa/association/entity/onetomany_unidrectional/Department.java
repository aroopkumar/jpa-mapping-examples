package com.example.jpa.association.entity.onetomany_unidrectional;


import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="one_to_many_uni_department")
public class Department {

    @Id
    private String id;

    @Column
    private String name;

    @OneToMany(cascade = CascadeType.REMOVE)
    private Set<EmployeeOneToManyUnidirectional> employees;

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

    public Set<EmployeeOneToManyUnidirectional> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<EmployeeOneToManyUnidirectional> employees) {
        this.employees = employees;
    }
}

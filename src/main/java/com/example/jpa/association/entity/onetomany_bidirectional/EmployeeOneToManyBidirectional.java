package com.example.jpa.association.entity.onetomany_bidirectional;


import com.example.jpa.association.entity.onetomany_unidrectional.Department;

import javax.persistence.*;

@Entity
@Table(name="one_to_many_bid_employee")
public class EmployeeOneToManyBidirectional {

    @Id
    private String id;

    @Column
    private String name;

    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name="department_id")
    private DepartmentBidirectional department;

    public DepartmentBidirectional getDepartment() {
        return department;
    }

    public void setDepartment(DepartmentBidirectional department) {
        this.department = department;
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

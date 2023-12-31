package com.example.jpa.association.entity.onetomany_unidrectional;


import javax.persistence.*;

@Entity
@Table(name="one_to_many_uni_employee")
public class EmployeeOneToManyUnidirectional {

    @Id
    private String id;

    @Column
    private String name;

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

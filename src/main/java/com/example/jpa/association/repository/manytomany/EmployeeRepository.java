package com.example.jpa.association.repository.manytomany;

import com.example.jpa.association.entity.manytomany.Employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface EmployeeRepository extends CrudRepository<Employee, String> {

}

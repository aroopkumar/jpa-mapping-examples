package com.example.jpa.association.repository.onetoone;


import com.example.jpa.association.entity.onetoone.EmployeeOneToOne;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeOneToOneRepository extends CrudRepository<EmployeeOneToOne, String> {

}

package com.example.jpa.association.repository.onetomany_unidirectional;

import com.example.jpa.association.entity.onetomany_unidrectional.Department;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface DepartmentRepository extends CrudRepository<Department, String> {

}

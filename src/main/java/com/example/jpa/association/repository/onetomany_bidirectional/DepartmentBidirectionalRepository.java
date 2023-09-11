package com.example.jpa.association.repository.onetomany_bidirectional;


import com.example.jpa.association.entity.onetomany_bidirectional.DepartmentBidirectional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentBidirectionalRepository extends CrudRepository<DepartmentBidirectional, String> {


}

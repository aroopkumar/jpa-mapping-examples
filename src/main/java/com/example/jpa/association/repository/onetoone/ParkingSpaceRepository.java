package com.example.jpa.association.repository.onetoone;

import com.example.jpa.association.entity.onetoone.ParkingSpace;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParkingSpaceRepository extends CrudRepository<ParkingSpace, String> {

}
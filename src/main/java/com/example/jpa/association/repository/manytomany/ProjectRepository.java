package com.example.jpa.association.repository.manytomany;

import com.example.jpa.association.entity.manytomany.Project;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ProjectRepository extends CrudRepository<Project, String> {

}

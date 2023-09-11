package com.example.jpa.inheritance.controller;


import com.example.jpa.inheritance.service.EntityManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/inheritance")
public class InheritanceTestController {

    @Autowired
    private EntityManagerService entityManagerService;

    @GetMapping("/single-table")
    public void createDataForPerson(){
        entityManagerService.testSaveData_Person_Student_Trainer();
    }

    @GetMapping("/table-per-subclass")
    public void createDataForPerson_Subclass(){
        entityManagerService.testSaveData_Person_Student_Trainer_SubClass();
    }

    @GetMapping("/table-per-class")
    public void createDataForPerson_PerClass(){
        entityManagerService.testSaveData_Person_Student_Trainer_PerClass();
    }


}

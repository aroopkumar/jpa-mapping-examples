package com.example.jpa.inheritance.service;


import com.example.jpa.inheritance.entity.singletable.Person;
import com.example.jpa.inheritance.entity.singletable.Student;
import com.example.jpa.inheritance.entity.singletable.Trainer;
import com.example.jpa.inheritance.entity.tableperclass.PersonPerClass;
import com.example.jpa.inheritance.entity.tableperclass.StudentPerClass;
import com.example.jpa.inheritance.entity.tableperclass.TrainerPerClass;
import com.example.jpa.inheritance.entity.tablepersubclass.PersonSub;
import com.example.jpa.inheritance.entity.tablepersubclass.StudentSub;
import com.example.jpa.inheritance.entity.tablepersubclass.TrainerSub;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;

@Service
public class EntityManagerService {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void testSaveData_Person_Student_Trainer(){
        Person person=new Person(101, "Test_Person");
        Student student=new Student(102, "Test_Student", "BTECH", 10000);
        Trainer trainer = new Trainer(103, "Test_Trainer", 8, 1000);
        entityManager.persist(person);
        entityManager.persist(student);
        entityManager.persist(trainer);
        System.out.println("Records Inserted for Person, Student and Trainer");
    }

    @Transactional
    public void testSaveData_Person_Student_Trainer_SubClass(){
        PersonSub person=new PersonSub(101, "Test_Person");
        StudentSub student=new StudentSub(102, "Test_Student", "BTECH", 10000);
        TrainerSub trainer = new TrainerSub(103, "Test_Trainer", 8, 1000);
        entityManager.persist(person);
        entityManager.persist(student);
        entityManager.persist(trainer);
        System.out.println("Records Inserted for Person, Student and Trainer-Table per sub class");
    }

    @Transactional
    public void testSaveData_Person_Student_Trainer_PerClass(){
        PersonPerClass person=new PersonPerClass(101, "Test_Person");
        StudentPerClass student=new StudentPerClass(102, "Test_Student", "BTECH", 10000);
        TrainerPerClass trainer = new TrainerPerClass(103, "Test_Trainer", 8, 1000);
        entityManager.persist(person);
        entityManager.persist(student);
        entityManager.persist(trainer);
        System.out.println("Records Inserted for Person, Student and Trainer-Table per sub class");
    }
}

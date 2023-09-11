package com.example.jpa.association.controller;


import com.example.jpa.association.entity.manytomany.Employee;
import com.example.jpa.association.entity.manytomany.Project;
import com.example.jpa.association.entity.onetomany_bidirectional.DepartmentBidirectional;
import com.example.jpa.association.entity.onetomany_bidirectional.EmployeeOneToManyBidirectional;
import com.example.jpa.association.entity.onetomany_unidrectional.Department;
import com.example.jpa.association.entity.onetomany_unidrectional.EmployeeOneToManyUnidirectional;
import com.example.jpa.association.entity.onetoone.EmployeeOneToOne;
import com.example.jpa.association.entity.onetoone.ParkingSpace;
import com.example.jpa.association.repository.manytomany.EmployeeRepository;
import com.example.jpa.association.repository.manytomany.ProjectRepository;
import com.example.jpa.association.repository.onetomany_bidirectional.DepartmentBidirectionalRepository;
import com.example.jpa.association.repository.onetomany_bidirectional.EmployeeOneToManyBidirectionalRepository;
import com.example.jpa.association.repository.onetomany_unidirectional.DepartmentRepository;
import com.example.jpa.association.repository.onetomany_unidirectional.EmployeeOneToManyUnidirectionalRepository;
import com.example.jpa.association.repository.onetoone.EmployeeOneToOneRepository;
import com.example.jpa.association.repository.onetoone.ParkingSpaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedHashSet;
import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping(path = "/association")
public class AssociationTestController {


    //one-to-one
    @Autowired
    private EmployeeOneToOneRepository employeeOneToOneRepository;
    @Autowired
    private ParkingSpaceRepository parkingSpaceRepository;

    //one-to-many-uni
    @Autowired
    private DepartmentRepository departmentRepository;
    @Autowired
    private EmployeeOneToManyUnidirectionalRepository employeeOneToManyUnidirectionalRepository;

    //one-to-many-bid
    @Autowired
    private DepartmentBidirectionalRepository departmentBidirectionalRepository;
    @Autowired
    private EmployeeOneToManyBidirectionalRepository employeeOneToManyBidirectionalRepository;

    //many-to-many
    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private ProjectRepository projectRepository;

    private static int count=0;
    private static int departmentCount=0;

    @GetMapping("/one-to-one-create")
    public void createOneToOne(){
        EmployeeOneToOne employee = new EmployeeOneToOne();
        employee.setId(String.valueOf(++count));
        employee.setName("Emp"+count);

        ParkingSpace parkingSpace = new ParkingSpace();
        parkingSpace.setId(String.valueOf(count));
        parkingSpace.setParkingNumber("Parking"+ count);
        parkingSpaceRepository.save(parkingSpace);

        employee.setParking(parkingSpace);
        employeeOneToOneRepository.save(employee);
        System.out.println("one-to-one Employee object created");
    }

    @GetMapping("/one-to-one-delete/{id}")
    public void deleteOneToOne(@PathVariable String id){
        employeeOneToOneRepository.deleteById(id);
        System.out.println("one-to-one Employee object deleted");
    }

    @GetMapping("/one-to-one-get/{id}")
    public EmployeeOneToOne getOneToOne(@PathVariable String id){
        Optional<EmployeeOneToOne> employeeOptional= employeeOneToOneRepository.findById(id);
        if(employeeOptional.isPresent()){
            return employeeOptional.get();
        }
        System.out.println("one-to-one Employee object returned");
        return null;
    }

    @GetMapping("/one-to-many-uni-create")
    public void createOneToManyUni(){
        EmployeeOneToManyUnidirectional employee1 = new EmployeeOneToManyUnidirectional();
        employee1.setId(String.valueOf(++count));
        employee1.setName("Emp"+count);

        EmployeeOneToManyUnidirectional employee2 = new EmployeeOneToManyUnidirectional();
        employee2.setId(String.valueOf(++count));
        employee2.setName("Emp"+count);

        Set<EmployeeOneToManyUnidirectional> employees = new LinkedHashSet<>();
        employees.add(employee1);
        employees.add(employee2);
        employeeOneToManyUnidirectionalRepository.saveAll(employees);

        Department department = new Department();
        department.setId(String.valueOf(++departmentCount));
        department.setName("Department "+ departmentCount);
        department.setEmployees(employees);
        departmentRepository.save(department);

        System.out.println("one-to-many-uni Department object created");
    }

    @GetMapping("/one-to-many-uni-delete/{id}")
    public void deleteOneToManyUni(@PathVariable String id){
        departmentRepository.deleteById(id);
        System.out.println("one-to-many-uni Department object deleted");
    }

    @GetMapping("/one-to-many-bid-create")
    public void createOneToManyBidirectional(){
        DepartmentBidirectional department = new DepartmentBidirectional();
        department.setId(String.valueOf(++departmentCount));
        department.setName("Department "+ departmentCount);

        EmployeeOneToManyBidirectional employee1 = new EmployeeOneToManyBidirectional();
        employee1.setId(String.valueOf(++count));
        employee1.setName("Emp"+count);
        employee1.setDepartment(department); //adding reference

        EmployeeOneToManyBidirectional employee2 = new EmployeeOneToManyBidirectional();
        employee2.setId(String.valueOf(++count));
        employee2.setName("Emp"+count);
        employee2.setDepartment(department);  //adding reference
        Set<EmployeeOneToManyBidirectional> employees = new LinkedHashSet<>();
        employees.add(employee1);
        employees.add(employee2);

        department.setEmployees(employees);
        departmentBidirectionalRepository.save(department);

        employeeOneToManyBidirectionalRepository.saveAll(employees);
        System.out.println("one-to-many-bid Department object created");
    }

    @GetMapping("/one-to-many-bid-delete/{id}")
    public void deleteOneToManyBidirectional(@PathVariable String id){
        departmentBidirectionalRepository.deleteById(id);
        System.out.println("one-to-many-bid Department object deleted");
    }


    private Project createProject(){
        Project project = new Project();
        project.setId(String.valueOf(++departmentCount));
        project.setName("Project "+ departmentCount);
        projectRepository.save(project);
        return project;
    }

    private Employee createEmployee(){
        Employee employee = new Employee();
        employee.setId(String.valueOf(++count));
        employee.setName("Emp"+count);
        employeeRepository.save(employee);
        return employee;
    }
    @GetMapping("/many-to-many-create")
    public void createManyToMany(){
        Set<Project> projectSet =new LinkedHashSet<>();
        Project project1 = createProject();
        Project project2 = createProject();
        projectSet.add(project1);
        projectSet.add(project2);

        Set<Project> projectSet2 =new LinkedHashSet<>();
        Project project3 = createProject();
        Project project4 = createProject();
        projectSet2.add(project3);
        projectSet2.add(project4);

        Set<Employee> employeeSet = new LinkedHashSet<>();
        Employee employee1 = createEmployee();
        employeeSet.add(employee1);

        Set<Employee> employeeSet2 = new LinkedHashSet<>();
        Employee employee2 = createEmployee();
        employeeSet2.add(employee2);

        employee1.setProjects(projectSet); //adding reference
        employeeRepository.saveAll(employeeSet);

        project1.setEmployees(employeeSet); //adding reference;
        project2.setEmployees(employeeSet); //adding reference;
        projectRepository.saveAll(projectSet);

        employee2.setProjects(projectSet2); //adding reference
        employeeRepository.saveAll(employeeSet2);

        project3.setEmployees(employeeSet2); //adding reference;
        project4.setEmployees(employeeSet2); //adding reference;
        projectRepository.saveAll(projectSet2);




        System.out.println("many-to-many Employee/Project object created");
    }

    @GetMapping("/many-to-many-delete-project/{id}")
    public void deleteManyToManyProject(@PathVariable String id){
        projectRepository.deleteById(id);
        System.out.println("many-to-many project object deleted");
    }

    @GetMapping("/many-to-many-delete-employee/{id}")
    public void deleteManyToManyEmployee(@PathVariable String id){
        employeeRepository.deleteById(id);
        System.out.println("many-to-many employee object deleted");
    }

    @GetMapping("/many-to-many-get-employee/{id}")
    public Employee getManyToManyEmployee(@PathVariable String id){
        Optional<Employee> employeeOptional= employeeRepository.findById(id);
        if(employeeOptional.isPresent()){
            return employeeOptional.get();
        }
        System.out.println("many-to-many Employee object returned");
        return null;
    }

    @GetMapping("/many-to-many-get-project/{id}")
    public Project getManyToManyProject(@PathVariable String id){
        Optional<Project> projectOptional= projectRepository.findById(id);
        if(projectOptional.isPresent()){
            return projectOptional.get();
        }
        System.out.println("many-to-many Employee object returned");
        return null;
    }
}

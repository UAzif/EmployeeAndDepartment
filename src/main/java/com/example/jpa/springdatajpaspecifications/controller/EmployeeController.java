package com.example.jpa.springdatajpaspecifications.controller;

import com.example.jpa.springdatajpaspecifications.entity.Department;
import com.example.jpa.springdatajpaspecifications.entity.Employees;
import com.example.jpa.springdatajpaspecifications.model.DepartmentResult;
import com.example.jpa.springdatajpaspecifications.model.EmployeesResult;
import com.example.jpa.springdatajpaspecifications.repository.DepartmentRepository;
import com.example.jpa.springdatajpaspecifications.repository.EmployeeRepository;
import static com.example.jpa.springdatajpaspecifications.specifications.EmployeeSpecification.*;
import org.springframework.beans.factory.annotation.Autowired;
import static org.springframework.data.jpa.domain.Specification.*;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@RestController
public class EmployeeController {
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private DepartmentRepository departmentRepository;

    @GetMapping("/departments")
    public List<DepartmentResult> getAllDepartments() {
        List<Department> departments = departmentRepository.findAll();
        List<DepartmentResult> depResults = departments.stream().
                map(n -> new DepartmentResult(n.getId(), n.getNameOfDepartment())).collect(Collectors.toList());
        return depResults;
    }
        // не работает-не выдает людай по департаментам
    @GetMapping("/employees/{department}")
    List<EmployeesResult> getEmployeesByDepartment(@PathVariable("department") String department){
        List<EmployeesResult> empRes=new ArrayList<>();
        List<Employees> employees = employeeRepository.findEmployeesByDepartment(department);
        for (Employees e:employees){
            EmployeesResult dep=new EmployeesResult(e.getId(), e.getFirstName(), e.getLastName());
            if (department.equals(e.getDepartment())){
            empRes.add(dep);
            }
        }
        System.out.println("работает метод empsByDepartment");
        return empRes;
    }


//    @GetMapping("/departments")
//    public List<DepartmentResult> getAllDepartments() {
//        List<Department> departments = departmentRepository.findAll();
//        List<DepartmentResult> depResults = departments.stream().
//                map(n-> new DepartmentResult(n.getId(),n.getNameOfDepartment())).collect(Collectors.toList());
//        return depResults;
//    }


    //    //работает вариант со стримом с использованием критерия
//    @GetMapping("/employees")
//    public List<EmployeesResult> findAllEmployees() {
//        List<Employees> employees = employeeRepository.findAll();
//        List<EmployeesResult> empRes = employees.stream().
//                map(n -> new EmployeesResult(n.getId(), n.getFirstName(), n.getLastName())).collect(Collectors.toList());
//        System.out.println("работает вариант со стримом с использованием критерия");
//        return empRes;
//    }
//        //работает
//    @GetMapping("/employees/{firstName}")
//    public List<EmployeesResult> findByFirstname(@PathVariable("firstName") String firstName) {
//        List<EmployeesResult> employeesResults = new ArrayList<>();
//        List<Employees> employees = employeeRepository.findEmployeeByFirstName(firstName);
//        for (Employees emp : employees) {
//            EmployeesResult erl = new EmployeesResult(emp.getId(), emp.getFirstName(), emp.getLastName());
//            employeesResults.add(erl);
//        }
//        return employeesResults;
//    }
   //// вот это со спецификацией
    @GetMapping("/employee/{firstName}")
    public List<EmployeesResult> findEmployeeByFirstName(@PathVariable("firstName") String firstName){
        List<EmployeesResult> employeesResults= new ArrayList<>();
        List<Employees> employees=employeeRepository.findAll(where(hasFirstName(firstName)));
        for (Employees emp : employees) {
            EmployeesResult erl = new EmployeesResult(emp.getId(), emp.getFirstName(), emp.getLastName());
            employeesResults.add(erl);
        }
        System.out.println("Это работает со спецификацией");
        return employeesResults;
    }





// работает вариант с forech с использованием критерия
    @GetMapping("/employees")
    public List<EmployeesResult> findAllEmployees() {
        List<EmployeesResult> empRes = new ArrayList<>();
        List<Employees> employees = employeeRepository.findAll();
        for (Employees emp : employees) {
            EmployeesResult erl = new EmployeesResult(emp.getId(), emp.getFirstName(), emp.getLastName());
            empRes.add(erl);
        }
        System.out.println("работает вариант с forech с использованием критерия");
        return empRes;
    }
}

//    @GetMapping("/employees/{lastname}")
//    public List<Employees> findByFirstnameAndDepartment(@PathVariable("lastname") String lastname){
//
//
//        return employeeRepository.findAll(containsLastName(lastname));
//    }
 //   }





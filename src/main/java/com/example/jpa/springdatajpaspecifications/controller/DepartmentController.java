//package com.example.jpa.springdatajpaspecifications.controller;
//
//import com.example.jpa.springdatajpaspecifications.entity.Department;
//import com.example.jpa.springdatajpaspecifications.model.DepartmentResult;
//import com.example.jpa.springdatajpaspecifications.repository.DepartmentRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.stream.Collectors;
//
//@RestController
//public class DepartmentController {
//    @Autowired
//    private DepartmentRepository departmentRepository;
//
//    ////работает выводит скопом
////    @GetMapping("/departments")
////    public List<Department> getAllDepartments(){
////        return departmentRepository.findAll();
////    }
//
//
//        //// работает но выводит только департаменты без людей
////    @GetMapping("/departments")
////    public List<DepartmentResult> getAllDepartments() {
////        List<Department> departments = departmentRepository.findAll();
////        List<DepartmentResult> depResults = departments.stream().
////                map(n -> new DepartmentResult(n.getId(), n.getNameOfDepartment())).collect(Collectors.toList());
////        return depResults;
////    }
//
//
//    @GetMapping("/departments")
//    public List<DepartmentResult> showAllDepartments() {
//        List<DepartmentResult> departmentResults = new ArrayList<>();
//        List<Department> departments = departmentRepository.findAll();
//        for (Department dep: departments){
//            DepartmentResult depR= new DepartmentResult(dep.getId(), dep.getNameOfDepartment());
//            departmentResults.add(depR);
//        }
//        return departmentResults;
//    }
//}

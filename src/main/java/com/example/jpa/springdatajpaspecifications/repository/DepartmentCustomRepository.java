package com.example.jpa.springdatajpaspecifications.repository;

import com.example.jpa.springdatajpaspecifications.entity.Department;

import java.util.List;

public interface DepartmentCustomRepository {
    List<Department> getAllByDepartment(String nameOfDepartment);

  //  List<Department> findEmployeesByDepartment(String department);

}

package com.example.jpa.springdatajpaspecifications.repository;

import com.example.jpa.springdatajpaspecifications.entity.Employees;

import java.util.List;

public interface EmployeeCustomRepository {
    List<Employees> findEmployeeByFirstName(String firstname);
    List<Employees> findEmployeeByFirstNameAndLastName(String firstname,String lastName);

    List<Employees> findEmployeesByDepartment(String department);
}

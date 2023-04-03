package com.example.jpa.springdatajpaspecifications.repository;

import com.example.jpa.springdatajpaspecifications.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface DepartmentRepository extends DepartmentCustomRepository,
                                                JpaRepository<Department,Integer>,
                                                 JpaSpecificationExecutor {

}

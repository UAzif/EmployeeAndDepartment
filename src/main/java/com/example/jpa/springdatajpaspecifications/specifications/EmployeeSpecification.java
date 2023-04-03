package com.example.jpa.springdatajpaspecifications.specifications;

import com.example.jpa.springdatajpaspecifications.model.Employee_;
import com.example.jpa.springdatajpaspecifications.entity.Employees;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

@Component
public class EmployeeSpecification {

    public static Specification<Employees> hasFirstName(String firstName){
        return ((root, criteriaQuery, criteriaBuilder) -> {
            return criteriaBuilder.equal(root.get("firstName"),firstName);
        });
    }
//    public static Specification<Employees> containsLastName(String lastname){
//        return ((root, criteriaQuery, criteriaBuilder) -> {
//            return criteriaBuilder.like(root.get(Employee_.LASTNAME),"%"+ lastname + "%");
//        });
//    }
//
//    public static Specification<Employees> hasFirstNameAndLastName(String firstName, String lastName){
//        return ((root, criteriaQuery, criteriaBuilder) -> {
//            return criteriaBuilder.equal(root.get(Employee_.DEPARTMENT),department);
//        });
//    }
}

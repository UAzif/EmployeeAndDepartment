package com.example.jpa.springdatajpaspecifications.specifications;

import com.example.jpa.springdatajpaspecifications.entity.Department;
import com.example.jpa.springdatajpaspecifications.model.Department_;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

@Component
public class DepartmentSpecification {

    public static Specification<Department>getFirstName(String firstName){
        return ((root, criteriaQuery, criteriaBuilder) -> {
            return criteriaBuilder.equal(root.get(Department_.NAME_OF_DEPARTMENT),firstName);
        });
    }
}

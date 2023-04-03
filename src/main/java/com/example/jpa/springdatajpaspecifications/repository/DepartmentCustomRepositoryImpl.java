package com.example.jpa.springdatajpaspecifications.repository;

import com.example.jpa.springdatajpaspecifications.entity.Department;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

public class DepartmentCustomRepositoryImpl implements DepartmentCustomRepository {
    @Autowired
    public EntityManager entityManager;
    @Override
    public List<Department> getAllByDepartment(String dep_name) {
        CriteriaBuilder criteriaBuilder= entityManager.getCriteriaBuilder();
        CriteriaQuery criteriaQuery = criteriaBuilder.createQuery(Department.class);
        Root<Department> departmentRoot= criteriaQuery.from(Department.class);
        Predicate nameOfDeprmentPredicate= criteriaBuilder.equal(departmentRoot.get("dep_name"), dep_name);
        criteriaQuery.where(nameOfDeprmentPredicate);
        TypedQuery<Department> query=entityManager.createQuery(criteriaQuery);
        return query.getResultList();
    }

//    @Override
//    public List<Department> findEmployeesByDepartment(String department) {
//        CriteriaBuilder criteriaBuilder= entityManager.getCriteriaBuilder();
//        CriteriaQuery criteriaQuery = criteriaBuilder.createQuery(Department.class);
//        Root<Department> departmentRoot= criteriaQuery.from(Department.class);
//        Predicate nameOfDeprmentPredicate= criteriaBuilder.equal(departmentRoot.get("department"), department);
//        criteriaQuery.where(nameOfDeprmentPredicate);
//        TypedQuery<Department> query=entityManager.createQuery(criteriaQuery);
//        return query.getResultList();
//    }
}

package com.example.jpa.springdatajpaspecifications.repository;

import com.example.jpa.springdatajpaspecifications.entity.Employees;
import org.springframework.beans.factory.annotation.Autowired;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.concurrent.Callable;

public class EmployeeCustomRepositoryImpl implements EmployeeCustomRepository {
    @Autowired
    private EntityManager entityManager;
    @Override
    public List<Employees> findEmployeeByFirstName(String firstName) {
        CriteriaBuilder cb=entityManager.getCriteriaBuilder();
        CriteriaQuery cq=cb.createQuery(Employees.class);
        Root<Employees> employee=cq.from(Employees.class);
        Predicate firstNamePredicate=cb.equal(employee.get("firstName"),firstName);
      //  Predicate departmentPredicate=cb.equal(employee.get(Employee_.DEPARTMENT),department);
       // cq.where(firstNamePredicate,departmentPredicate);
        cq.where(firstNamePredicate);
        TypedQuery<Employees> query=entityManager.createQuery(cq);
        return query.getResultList();
    }

    @Override
    public List<Employees> findEmployeeByFirstNameAndLastName(String firstName,String lastName) {
        CriteriaBuilder criteriaBuilder=entityManager.getCriteriaBuilder();
        CriteriaQuery criteriaQuery=criteriaBuilder.createQuery(Employees.class);
        Root<Employees> root =criteriaQuery.from(Employees.class);
        Predicate lastNamePredicate =criteriaBuilder.equal(root.get("lastName"), lastName);
        Predicate firstNamePredicate =criteriaBuilder.equal(root.get("firstName"), firstName);
        criteriaQuery.where(firstNamePredicate,lastNamePredicate);
        TypedQuery<Employees> query= entityManager.createQuery(criteriaQuery);
        return query.getResultList();
    }

    @Override
    public List<Employees> findEmployeesByDepartment(String department) {
       CriteriaBuilder criteriaBuilder= entityManager.getCriteriaBuilder();
       CriteriaQuery criteriaQuery=criteriaBuilder.createQuery(Employees.class);
       Root<Employees>root=criteriaQuery.from(Employees.class);
       Predicate employeesByDepartmentPredicate=criteriaBuilder.equal(root.get("department"), department);
       TypedQuery<Employees> query= entityManager.createQuery(criteriaQuery);
        return query.getResultList();
    }

}

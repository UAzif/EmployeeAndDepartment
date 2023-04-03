package com.example.jpa.springdatajpaspecifications.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "department")
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
  @Column(name = "name_of_department")
    private String nameOfDepartment;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "department")
    private List<Employees> employees;

}

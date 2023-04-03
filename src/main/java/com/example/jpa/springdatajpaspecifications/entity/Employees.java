package com.example.jpa.springdatajpaspecifications.entity;

import com.example.jpa.springdatajpaspecifications.entity.Department;
import lombok.*;

import javax.persistence.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "employees")
public class Employees {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

   @Column(name = "first_name")
    private String firstName;

   @Column(name = "last_name")
    private String lastName;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "department_id")
    private Department department;



}

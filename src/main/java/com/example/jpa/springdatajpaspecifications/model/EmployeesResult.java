package com.example.jpa.springdatajpaspecifications.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeesResult {

    private  int id;
    private String firstName;
    private String lastName;

}

package com.example.employee.service;

import com.example.employee.data.Employee;

import java.util.Collection;
import java.util.Collections;

public interface EmployeeService {

    Employee add(String firstName, String lastName, int department, int salary);

    Employee add(Employee employee);

    Employee remove(String firstName, String lastName);

    Employee remove(Employee employee);

    Employee find(String firstName, String lastName);

    Collection<Employee> getAll();

}

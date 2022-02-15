package com.example.employee.service.impl;

import com.example.employee.data.Employee;
import com.example.employee.exception.EmployeeExistsException;
import com.example.employee.exception.EmployeeNotFoundException;
import com.example.employee.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final Set<Employee> employees;

    public EmployeeServiceImpl() {
        employees = new HashSet<>();
    }

    @Override
    public Employee add(String firstName, String lastName, int department, int salary) {
        Employee newEmployee = new Employee(firstName, lastName, department, salary);
        return add(newEmployee);
    }

    @Override
    public Employee add(Employee employee) {
//        boolean employeeAlreadyExists = !employees.add(employee);
        if (ifEmployeeAlreadyExists(employee)) {
            throw new EmployeeExistsException();
        }
        return employee;
    }

    @Override
    public Employee remove(String firstName, String lastName) {
        Employee newEmployee = new Employee(firstName, lastName);
        return remove(newEmployee);
    }

    @Override
    public Employee remove(Employee employee) {
        if (!employees.remove(employee)) {
            throw new EmployeeNotFoundException();
        }
        return employee;
    }

    @Override
    public Employee find(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (!employees.contains(employee)) {
            throw new EmployeeNotFoundException();
        }
        return employee;
    }

    @Override
    public Collection<Employee> getAll() {
        return employees;
    }

    private boolean ifEmployeeAlreadyExists(Employee employee) {
        for (Employee currentEmployee : employees) {
            if (currentEmployee.equals(employee)) {
                return false;
            }
        }
        return true;
    }
}

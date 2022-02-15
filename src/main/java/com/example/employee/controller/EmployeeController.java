package com.example.employee.controller;


import com.example.employee.data.Employee;
import com.example.employee.service.EmployeeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.Collections;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/add")
    public String add(@RequestParam String firstName,
                      @RequestParam String lastName,
                      @RequestParam(name = "departmentId", required = false) int department,
                      @RequestParam(required = false) int salary) {
        Employee result = employeeService.add(firstName, lastName, department, salary);
        return generateMessage(result, "успешно создан");
    }

    @GetMapping("/remove")
    public String remove(@RequestParam String firstName, @RequestParam String lastName) {
        Employee result = employeeService.remove(firstName, lastName);
        return generateMessage(result, "удален");
    }

    @GetMapping("/find")
    public Employee find(@RequestParam String firstName, @RequestParam String lastName) {
        return employeeService.find(firstName, lastName);
    }

    @GetMapping("/all")
    public Collection<Employee> all() {
        return employeeService.getAll();
    }

    private String generateMessage(Employee employee, String status) {
        return String.format("Сотрудник %s %s %s.", employee.getLastName(), employee.getFirstName(), status);
    }
}

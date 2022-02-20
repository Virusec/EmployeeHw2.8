package pro.sky.employee.service.impl;

import pro.sky.employee.data.Employee;
import pro.sky.employee.exception.EmployeeNotFoundException;
import pro.sky.employee.service.DepartmentService;
import pro.sky.employee.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    private final EmployeeService employeeService;

    public DepartmentServiceImpl(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @Override
    public Employee getEmployeeWithMinSalary(int department) {
        return employeeService.getAll().stream()
                .filter(employee -> employee.isInDepartment(department))
                .min(Comparator.comparing(Employee::getSalary))
                .orElseThrow(() -> new EmployeeNotFoundException("Работника для отдела " + department + " не найден"));
    }

    @Override
    public Employee getEmployeeWithMaxSalary(int department) {
        return employeeService.getAll().stream()
                .filter(employee -> employee.isInDepartment(department))
                .max(Comparator.comparing(Employee::getSalary))
                .orElseThrow(() -> new EmployeeNotFoundException("Работника для отдела " + department + " не найден"));
    }

    @Override
    public Collection<Employee> getEmployeesFor(int department) {
        return employeeService.getAll().stream()
                .filter(employee -> employee.isInDepartment(department))
                .collect(Collectors.toList());
    }

    @Override
    public Map<Integer, List<Employee>> getAllEmployeesByDepartment() {
        return employeeService.getAll().stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));
    }

}

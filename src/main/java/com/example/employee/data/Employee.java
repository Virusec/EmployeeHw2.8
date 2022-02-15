package com.example.employee.data;

import java.util.Objects;

public class Employee {
    private final String firstName;
    private final String lastName;
    private int department;
    private int salary;

    public Employee(String firstName, String lastName) {
        this(firstName, lastName, 0, 0);
    }

    public Employee(String firstName, String lastName, int department, int salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.department = department;
        this.salary = salary;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getDepartment() {
        return department;
    }

    public void setDepartment(int department) {
        this.department = department;
    }

    public boolean isInDepartment(int department) {
        return this.department == department;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return department == employee.department && salary == employee.salary && Objects.equals(firstName, employee.department);
    }

    @Override
    public String toString() {
        return "Employee{" + "firstName='" + firstName + '\'' + ", lastName='" + lastName + "\'" + ", department=" + department + ", salary=" + salary + '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName,lastName, department, salary);
    }
}

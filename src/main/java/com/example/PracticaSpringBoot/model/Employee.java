package com.example.PracticaSpringBoot.model;

import jakarta.persistence.*;
//mapare table la entitate si invers
//avem nevoie de o interfata pentru asta => EmployeeRepository
@Entity
@Table(name="t_employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name="firstname")
    private String firstName;
    @Column(name="lastname")
    private String lastName;
    @Column(name="monthly_salary")
    private int salary;

    @ManyToOne
    @JoinColumn(name="id_department")
    private Department  department;

    public Employee() {

    }

    public Employee(int id, String firstName, String lastName, int salary) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + firstName + '\'' +
                ", salary=" + salary +
                '}';
    }

    public String getDepartmentCode() {
        return department.getCode();
    }

    public String getDepartmentName() {
        return department.getName();
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}

package com.example.PracticaSpringBoot.repository;

import com.example.PracticaSpringBoot.model.Department;
import com.example.PracticaSpringBoot.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Integer> {
}

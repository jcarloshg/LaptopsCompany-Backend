package com.example.laptopcompany.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.laptopcompany.entity.Employee;

public interface EmployeeJPARepository extends JpaRepository<Employee, Integer> {

}

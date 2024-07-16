package com.example.laptopcompany.service;

import java.util.List;

import com.example.laptopcompany.entity.Employee;

public interface EmployeeService {

    // ============================================================
    // CREATE && UPDATE
    // ============================================================
    /**
     * If the ID is 0, then the method will create a new employee.
     * Otherwise, the employee will be updated
     *
     * @param employee
     * @return
     */
    Employee save(Employee employee);

    // ============================================================
    // READ
    // ============================================================

    List<Employee> findAll();

    Employee findByID(int id);

    // ============================================================
    // DELETE
    // ============================================================

    void deleteByID(int id);

}

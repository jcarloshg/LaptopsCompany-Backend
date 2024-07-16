package com.example.laptopcompany.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.laptopcompany.entity.Employee;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

/**
 * This class has the task to connect with DataBase
 */
@Repository
public class EmployeeMySqlJPA implements EmployeeDAO {

    private EntityManager entityManager;

    @Autowired
    public EmployeeMySqlJPA(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    // ============================================================
    // CREATE && UPDATE
    // This method won't have <@Transaction> 'cause,
    // the service is going to get.
    // ============================================================
    @Override
    public Employee save(Employee employee) {
        Employee employeeModified = this.entityManager.merge(employee);
        return employeeModified;
    }

    // ============================================================
    // READ
    // ============================================================
    @Override
    public List<Employee> findAll() {
        TypedQuery<Employee> query = entityManager.createQuery("from Employee", Employee.class);
        List<Employee> employees = query.getResultList();
        return employees;
    }

    @Override
    public Employee findByID(int id) {
        Employee employee = entityManager.find(Employee.class, id);
        return employee;
    }

    // ============================================================
    // DELETE
    // ============================================================
    @Override
    public void deleteByID(int id) {
        Employee employee = this.entityManager.find(Employee.class, id);
        this.entityManager.remove(employee);
    }

}

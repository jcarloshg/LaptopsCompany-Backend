package com.example.laptopcompany.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.laptopcompany.dao.EmployeeDAO;
import com.example.laptopcompany.dao.EmployeeJPARepository;
import com.example.laptopcompany.entity.Employee;

import jakarta.transaction.Transactional;

@Service
public class EmployeeServiceImplement implements EmployeeService {

    // private EmployeeJPARepository employeeDAO;
    private EmployeeJPARepository employeeJPARepository;

    // @Autowired
    // public EmployeeServiceImplement(EmployeeDAO employeeDAO) {
    // this.employeeDAO = employeeDAO;
    // }

    @Autowired
    public EmployeeServiceImplement(EmployeeJPARepository employeeJPARepository) {
        this.employeeJPARepository = employeeJPARepository;
    }

    // ============================================================
    // CREATE && UPDATE
    // ============================================================
    @Override
    // @Transactional this task passes to <<EmployeeJPARepository>>
    public Employee save(Employee employee) {
        return this.employeeJPARepository.save(employee);
    }

    // ============================================================
    // READ
    // ============================================================
    @Override
    public List<Employee> findAll() {
        return employeeJPARepository.findAll();
    }

    @Override
    public Employee findByID(int id) {

        // return this.employeeJPARepository.findById(id);

        Optional<Employee> employee = this.employeeJPARepository.findById(id);

        if (employee.isPresent() == false)
            throw new RuntimeException("The employee doesn't exist");

        return employee.get();

    }

    // ============================================================
    // DELETE
    // ============================================================
    @Override
    // @Transactional this task passes to <<EmployeeJPARepository>>
    public void deleteByID(int id) {
        // this.employeeJPARepository.deleteByID(id);
        this.employeeJPARepository.deleteById(id);
    }

}

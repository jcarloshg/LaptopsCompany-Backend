package com.example.laptopcompany.restcotroller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.laptopcompany.entity.Employee;
import com.example.laptopcompany.service.EmployeeServiceImplement;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    private EmployeeServiceImplement employeeServiceImplement;

    public EmployeeRestController(EmployeeServiceImplement employeeServiceImplement) {
        this.employeeServiceImplement = employeeServiceImplement;
    }

    // CREATE

    @PostMapping("/employees")
    public Employee create(@RequestBody Employee employee) {
        System.out.println("this is " + employee.toString());
        employee.setId(0);
        Employee employeeSaved = this.employeeServiceImplement.save(employee);
        return employeeSaved;
    }

    // READ

    @GetMapping("/employees")
    public List<Employee> getAll() {
        return employeeServiceImplement.findAll();
    }

    @GetMapping("/employees/{id}")
    public Employee getByID(@PathVariable int id) {
        System.out.println(id);
        Employee employee = employeeServiceImplement.findByID(id);
        if (employee == null) {
            throw new RuntimeException("Employee not founded -> " + id);
        }
        return employee;
    }

    // UPDATE

    @PutMapping("/employees")
    public Employee update(@RequestBody Employee employee) {
        Employee employeeUpdated = employeeServiceImplement.save(employee);
        return employeeUpdated;
    }

    // DELETE

    @DeleteMapping("/employees/{id}")
    public String deleteByID(@PathVariable int id) {
        Employee employeeFounded = employeeServiceImplement.findByID(id);
        if (employeeFounded == null) {
            throw new RuntimeException("The employee with " + id + " doesn't exist");
        }
        employeeServiceImplement.deleteByID(id);

        return "Deleted employee with " + id;
    }

}

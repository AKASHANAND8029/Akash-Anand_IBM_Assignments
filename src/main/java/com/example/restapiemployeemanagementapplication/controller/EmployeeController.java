package com.example.restapiemployeemanagementapplication.controller;

import com.example.restapiemployeemanagementapplication.model.Employee;
import com.example.restapiemployeemanagementapplication.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
public class EmployeeController {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/")
    public String sayHello()
    {

        return "Hello world REST";
    }
    @GetMapping("/employees")
    public Collection<Employee> getEmployee()
    {

        return employeeService.getAllEmployees();
    }
    @PostMapping("/employees")
    public Employee createEmployee(@RequestBody Employee employee)
    {
        return employeeService.createEmployee(employee);
    }
    @GetMapping("/employees/{id}")
    public Employee findEmployee(@PathVariable("id") Integer id)
    {
        return employeeService.findEmployeeById(id);
    }
    @DeleteMapping("/employees/{id}")
    public String deleteEmployee(@PathVariable("id") Integer id)
    {
        employeeService.deleteEmployeeById(id);
        return "deletion successful";
    }
    @PutMapping("/employees/{id}")
    public Employee updateEmployee(@RequestBody Employee employee,@PathVariable("id") Integer id)
    {
        return employeeService.updateEmployee(employee,id);
    }
}
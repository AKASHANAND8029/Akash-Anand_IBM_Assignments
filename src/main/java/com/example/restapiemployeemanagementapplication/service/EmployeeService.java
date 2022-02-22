package com.example.restapiemployeemanagementapplication.service;

import com.example.restapiemployeemanagementapplication.model.Employee;

import java.util.Collection;

public interface EmployeeService {
    public Employee createEmployee(Employee employee);
    public Collection<Employee> getAllEmployees();
    public Employee findEmployeeById(Integer id);
    public void deleteEmployeeById(Integer id);
    public Employee updateEmployee(Employee employee,Integer id);
}

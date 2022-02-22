package com.example.restapiemployeemanagementapplication.repository;

import com.example.restapiemployeemanagementapplication.model.Employee;

import java.util.Collection;

public interface EmployeeRepository {

    public Employee createEmployee(Employee employee);

    public Collection<Employee> getAllEmployees();

    public Employee findEmployeeById(Integer id);

    public void deleteEmployeeById(Integer id);
    public Employee updateEmployee(Employee employee,Integer id);

}
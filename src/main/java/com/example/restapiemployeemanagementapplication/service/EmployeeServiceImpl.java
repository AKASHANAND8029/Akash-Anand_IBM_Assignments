package com.example.restapiemployeemanagementapplication.service;

import com.example.restapiemployeemanagementapplication.model.Employee;
import com.example.restapiemployeemanagementapplication.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
@Service
public class EmployeeServiceImpl implements EmployeeService{
    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Employee createEmployee(Employee employee) {
        return employeeRepository.createEmployee(employee);
    }

    @Override
    public Collection<Employee> getAllEmployees() {
        return employeeRepository.getAllEmployees();
    }

    @Override
    public Employee findEmployeeById(Integer id) {
        return employeeRepository.findEmployeeById(id);
    }

    @Override
    public void deleteEmployeeById(Integer id) {
        employeeRepository.deleteEmployeeById(id);
    }

    @Override
    public Employee updateEmployee(Employee employee, Integer id) {
        return employeeRepository.updateEmployee(employee,id);

    }
}

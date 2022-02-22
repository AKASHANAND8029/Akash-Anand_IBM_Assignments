package com.example.restapiemployeemanagementapplication.repository;

import com.example.restapiemployeemanagementapplication.model.Employee;
import com.example.restapiemployeemanagementapplication.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class EmployeeRepositoryImpl implements EmployeeRepository{

    private final Map<Integer, Employee> map;

    @Autowired
    public EmployeeRepositoryImpl(Map<Integer, Employee> map) {
        this.map = map;
    }

    @Override
    public Employee createEmployee(Employee employee) {
        map.put(new Random().nextInt(1000),employee);
        return employee;
    }

    @Override
    public Collection<Employee> getAllEmployees() {
        System.out.println(map);
        return map.values();
    }

    @Override
    public Employee findEmployeeById(Integer id) {
        return map.get(id);
    }

    @Override
    public void deleteEmployeeById(Integer id) {

        map.remove(id);
    }

    @Override
    public Employee updateEmployee(Employee employee, Integer id) {
        Employee tempEmployee=findEmployeeById(id);
        tempEmployee.setEmployeeId(employee.getEmployeeId());
        tempEmployee.setEmployeeName(employee.getEmployeeName());
        return tempEmployee;
    }
}

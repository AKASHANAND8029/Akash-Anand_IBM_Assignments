//package org.example.model;
//
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//import lombok.ToString;
//
//import javax.persistence.*;
//
//@NoArgsConstructor
//@AllArgsConstructor
//@Data
//@Entity
//@Table(name = "employee")
//public class Employee {
//    @Id
//    @Column(name = "id")
//    private Integer id;
//    @Column(name = "employee_unique_id",nullable = false,unique = true)
//    private String employeeId;
//    @Column(name = "employee_name",nullable = false)
//    private String employeeName;
//    @Column(name = "employee_salary",nullable = false, precision = 2)
//    private Double salary;
//    @Enumerated(EnumType.STRING)
//    @Column(name = "type_of_employee",nullable = false)
//    private EmployeeType employeeType;
//
//    @Override
//    public String toString() {
//        StringBuffer stringBuffer=new StringBuffer();
//        stringBuffer.append("Employee ID: "+getEmployeeId()+" Employee Name: "+getEmployeeName()+" Employee Salary: "
//                +getSalary()+" Employee Type: "+getEmployeeType().getType());
//        return stringBuffer.toString();
//    }
//
//}
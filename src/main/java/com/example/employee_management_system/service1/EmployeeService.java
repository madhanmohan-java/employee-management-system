package com.example.employee_management_system.service1;

import com.example.employee_management_system.entity.Employee;

import java.util.List;

public interface EmployeeService {


        Employee saveEmployee(Employee employee);


        List<Employee> getAllEmployees();


        Employee getEmployeeById(Long id);


        Employee updateEmployee(Long id, Employee employee);


        void deleteEmployee(Long id);

    }


package com.example.employee_management_system.controller;

import com.example.employee_management_system.entity.Employee;
import com.example.employee_management_system.service1.EmployeeService;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;

    import org.springframework.web.bind.annotation.*;

    import java.util.List;

@RestController
    @RequestMapping("/api/employees")
    public class EmployeeController {

        private final EmployeeService employeeService;

        public EmployeeController(EmployeeService employeeService) {
            this.employeeService = employeeService;
        }
        @PostMapping
        public Employee saveEmployee(@RequestBody Employee employee) {
            return employeeService.saveEmployee(employee);
        }
        @GetMapping
        public List<Employee> getAllEmployees() {
            return employeeService.getAllEmployees();
        }

    }

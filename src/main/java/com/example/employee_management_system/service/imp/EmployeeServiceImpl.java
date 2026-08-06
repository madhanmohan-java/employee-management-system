package com.example.employee_management_system.service.imp;

import com.example.employee_management_system.entity.Employee;
import com.example.employee_management_system.repository.EmployeeRepository;
import com.example.employee_management_system.service1.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class EmployeeServiceImpl implements EmployeeService  {


    private final EmployeeRepository employeeRepository;


    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }


    @Override
    public Employee saveEmployee(Employee employee) {

        return employeeRepository.save(employee);
    }


    @Override
    public List<Employee> getAllEmployees() {

        return employeeRepository.findAll();
    }


    @Override
    public Employee getEmployeeById(Long id) {

        return employeeRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Employee not found with id : " + id)
                );
    }


    @Override
    public Employee updateEmployee(Long id, Employee employee) {


        Employee existingEmployee = employeeRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Employee not found with id : " + id)
                );


        existingEmployee.setName(employee.getName());
        existingEmployee.setEmail(employee.getEmail());
        existingEmployee.setDepartment(employee.getDepartment());
        existingEmployee.setSalary(employee.getSalary());


        return employeeRepository.save(existingEmployee);
    }


    @Override
    public void deleteEmployee(Long id) {


        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Employee not found with id : " + id)
                );


        employeeRepository.delete(employee);
    }

}

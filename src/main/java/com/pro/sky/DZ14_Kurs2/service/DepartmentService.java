package com.pro.sky.DZ14_Kurs2.service;


import com.pro.sky.DZ14_Kurs2.exception.*;
import com.pro.sky.DZ14_Kurs2.model.Employee;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class DepartmentService {

    private final EmployeeService employeeService;

    public DepartmentService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
    public Employee getEmployeeWithMaxSalary (int department) {
        return employeeService.getAll().stream()
                .filter(employee -> employee.getDepartment() == department)
                .max(Comparator.comparingDouble(Employee::getSalary))
                .orElseThrow(EmployeeNotFoundException::new);
    }
    public Employee getEmployeeWithMinSalary (int department) {
        return employeeService.getAll().stream()
                .filter(employee -> employee.getDepartment() == department)
                .min(Comparator.comparingDouble(Employee::getSalary))
                .orElseThrow(EmployeeNotFoundException::new);
    }

    public List<Employee> getAll (int department){
        return employeeService.getAll().stream()
                .filter(employee -> employee.getDepartment() == department)
                .collect(Collectors.toList());

    }

    public Map<Integer,List<Employee>> getAll() {
        return employeeService.getAll().stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));
    }
    public double getEmployeeSalarySum (int depatment){
        return employeeService.getAll().stream()
                .filter(e -> e.getDepartment() == depatment)
                .mapToDouble(Employee::getSalary)
                .max()
                .orElseThrow(EmployeeNotFoundException::new);
    }
}



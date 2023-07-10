package com.pro.sky.DZ14_Kurs2.service;

import com.pro.sky.DZ14_Kurs2.model.Employee;
import org.assertj.core.util.Arrays;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class DepartmentServiceTest {
    private static final Collection<Employee> EMPLOYEES = Arrays.asList(
            new Employee("ivan", "petrov", 1, 10000),
            new Employee("sergey", "petrov", 1, 20000),
            new Employee("polina", "petrova", 2, 15000),
            new Employee("natalia", "gorag", 2, 50000),
            new Employee("nina", "petrova", 3, 60000)
            );
    @Mock
    EmployeeService employeeService;
    @InjectMocks
    DepartmentService departmentService;

    @BeforeEach
    void init() {

        when(employeeService.getAll()).thenReturn(EMPLOYEES);

    }
    @Test
    void sum(){
        double actual = departmentService.getEmployeeSalarySum(1);
        assertEquals(30000.0,actual);
    }

    }

package com.pro.sky.DZ14_Kurs2.service;

import com.pro.sky.DZ14_Kurs2.model.Employee;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class DepartmentServiceTest {

    @Mock
    EmployeeService employeeService;
    @InjectMocks
    DepartmentService departmentService;

    @BeforeEach
    void init() {

        Collection<Employee> employees = Arrays.asList(
                new Employee("ivan", "petrov", 1, 10000),
                new Employee("olga", "petrova", 1, 20000),
                new Employee("oleg", "ivanov", 2, 10000),
                new Employee("stepan", "russkih", 2, 50000)

        );
        when(employeeService.getAll()).thenReturn(employees);
    }
    @Test
    void sum(){
        double actual = departmentService.getEmployeeSalarySum(1);
        assertEquals(30000.0,actual);
    }

    }

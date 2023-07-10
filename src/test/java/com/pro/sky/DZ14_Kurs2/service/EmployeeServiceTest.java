package com.pro.sky.DZ14_Kurs2.service;

import com.pro.sky.DZ14_Kurs2.exception.EmployeeAlreadyAddedException;
import com.pro.sky.DZ14_Kurs2.exception.EmployeeStorageIsFullException;
import com.pro.sky.DZ14_Kurs2.model.Employee;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class EmployeeServiceTest {
    EmployeeService employeeService = new EmployeeService();

    @Test
    void whenFullThenTrowException(){
        for (int i = 0; i < 5; i++) {
            char additionalChar = (char) ('a' + i);
            Employee employee = new Employee("name"+additionalChar, "sec_name", 1, 1);
            employeeService.add(employee);
        }

        assertThrows(EmployeeStorageIsFullException.class,
                () -> employeeService.add(new Employee("a", "b", 1, 1)));
    }

    @Test
    void whenNotUniqThenThrowException(){
        Employee employee = new Employee("name", "lastname", 1, 1);
        employeeService.add(employee);
        assertThrows(EmployeeAlreadyAddedException.class, () -> employeeService.add(employee));
    }
    @Test
    void addPositive(){
        Employee employee = new Employee("name", "last_name", 1, 1);
        employeeService.add(employee);
        assertTrue(employeeService.getAll().contains(employee));
    }
}

package com.pro.sky.DZ14_Kurs2.service;

import com.pro.sky.DZ14_Kurs2.exception.EmployeeStorageIsFullException;
import com.pro.sky.DZ14_Kurs2.model.Employee;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class EmployeeServiceTest {
    EmployeeService employeeService = new EmployeeService();

    @Test
    void whenFullThenTrowException(){
        for (int i = 0; i < 5; i++) {
            char additionalChar = (char) ('a' + i);
            Employee employee = new Employee("name"+additionalChar, "sec_name", 1, 1);
            employeeService.add(employee);
        }

        Assertions.assertThrows(EmployeeStorageIsFullException.class,
                () -> employeeService.add(new Employee("a", "b", 1, 1)));
    }
}

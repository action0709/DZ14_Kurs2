package com.pro.sky.DZ14_Kurs2.service;

import com.pro.sky.DZ14_Kurs2.exception.EmployeeAlreadyAddedException;
import com.pro.sky.DZ14_Kurs2.exception.EmployeeNotFoundException;
import com.pro.sky.DZ14_Kurs2.exception.EmployeeStorageIsFullException;
import com.pro.sky.DZ14_Kurs2.model.Employee;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class EmployeeService {
    private final Map<String, Employee> employees = new HashMap(MAX_SIZE);
    final static private int MAX_SIZE = 5;
    public EmployeeService() {
        Employee employee1 = new Employee("Petr", "Sidorov", 1, 10000);
        Employee employee2 = new Employee("Олег", "Sidorov", 1, 30000);
        Employee employee3 = new Employee("Мария", "Sidorovа", 1, 40000);
        Employee employee4 = new Employee("Сергей", "Sidorov", 1, 50000);
     //   employees.put(createKey(employee1), employee1);
        //  employees.put(createKey(employee2), employee2);
       // employees.put(createKey(employee3), employee3);
       // employees.put(createKey(employee4), employee4);
    }
    public Collection<Employee> getAll() {
        return employees.values();
    }
    public Employee add(Employee employee) {
        if (employees.size() >= MAX_SIZE) {
            throw new EmployeeStorageIsFullException();
        }
        if (employees.containsKey(createKey(employee))) {
            throw new EmployeeAlreadyAddedException();
        }
        employees.put(createKey(employee),employee);
        return employee;
    }

    public Employee remove(String firstName, String lastName) {
        return employees.remove(createKey(firstName, lastName));
    }

    public Employee find(String firstName, String lastName) {
        Employee employee = employees.get(createKey(firstName, lastName));
        if (employee==null){
            throw new EmployeeNotFoundException();
        }
        return employee;
    }

//    public List<Employee> getAll() {
//        return Collections.unmodifiableList(new ArrayList<>(employees.values()));
//    }

    private static String createKey(String firstName,String lastName) {
        return (firstName + lastName).toLowerCase();
    }
    private static String createKey(Employee employee) {
        return createKey(employee.getFirstName(),employee.getLastName());
    }
}

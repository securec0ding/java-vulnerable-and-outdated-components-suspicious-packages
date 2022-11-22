package com.hunter2.sqli.service;

import com.hunter2.sqli.model.Employee;
import com.hunter2.sqli.repository.EmployeeRepository;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class EmployeeService {
    private static final Logger LOGGER = Logger.getLogger(EmployeeService.class);

    @Autowired
    EmployeeRepository repository;

   public void init(){
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("Jon Snow", "jon@snow.got", "King of the north", "999-999-999", 50000));
        employees.add(new Employee("Tyrion Lannister", "tyrion@lannister.got", "Hand of the queen", "888-888-888", 100000));
        employees.add(new Employee("Arya Stark", "arya@stark.got", "No-one", "777-888-888", 22000));
        employees.add(new Employee("Cersei Lannister", "cersei@lannister.got", "Protector of the realm", "123-456-789", 200000));
        this.save(employees);
    }

    public List<Employee> getEmployeesByName(String name, Sort sort) {
       try {
           String lowerCaseName = name;
           if (name != null) {
               lowerCaseName = name.toLowerCase();
           }
           return repository.getEmployeesByName(lowerCaseName, sort);
       }catch (Exception e){
           LOGGER.error(e);
       }
       return Collections.emptyList();
    }

    public List<Employee> save(List<Employee> employeeList) {
       return repository.save(employeeList);
    }
}
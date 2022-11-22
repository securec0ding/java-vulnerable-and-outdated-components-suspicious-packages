package com.hunter2.sqli.repository;

import com.hunter2.sqli.model.Employee;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, String> {
    @Query(value = "SELECT e FROM Employee e WHERE LOWER(e.name) LIKE %:keyword%")
    List<Employee> getEmployeesByName(@Param("keyword") String keyword, Sort sort);
}
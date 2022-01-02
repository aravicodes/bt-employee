package com.cg.bugtracking.employee.repository;

import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.bugtracking.employee.entity.Employee;

@Repository("er")
public interface IEmployeeRepository extends JpaRepository<Employee,Long> {

}

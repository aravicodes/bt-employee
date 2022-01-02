package com.cg.bugtracking.employee.service;

import java.util.List;

import javax.validation.Valid;

import com.cg.bugtracking.employee.dto.EmployeeDto;
import com.cg.bugtracking.employee.entity.Employee;

public interface IEmployeeService {
	public EmployeeDto createEmployee(EmployeeDto employeeDto);
	public EmployeeDto updateEmployee(EmployeeDto employeeDto);
	public EmployeeDto deleteEmployee(long empId);
	public EmployeeDto getEmployee(long empId);
	public  List<EmployeeDto> getAllEmployees();

}

package com.cg.bugtracking.employee.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.bugtracking.employee.dto.EmployeeDto;
import com.cg.bugtracking.employee.entity.Employee;
import com.cg.bugtracking.employee.repository.IEmployeeRepository;
import com.google.common.base.Optional;

@Service("es")
@Transactional
public class EmployeeServiceImpl implements IEmployeeService{
	
	@Autowired
	IEmployeeRepository er;

	@Override
	public EmployeeDto createEmployee(EmployeeDto e) {
		er.save(e);
		return "created";
	}

	@Override
	public String updateEmployee(EmployeeDto e) {
		er.save(e);
		return "updated";
	}

	@Override
	public String deleteEmployee(long empId) {
		er.deleteById(empId);
		return "deleted";
	}

	@Override
	public Employee getEmployee(long empId) {
		java.util.Optional<Employee> emp=er.findById(empId);
		if(emp.isPresent())
			return emp.get();
		else
			return null;
	}

	@Override
	public List<Employee> getAllEmployees() {
		return er.findAll();
	}

}

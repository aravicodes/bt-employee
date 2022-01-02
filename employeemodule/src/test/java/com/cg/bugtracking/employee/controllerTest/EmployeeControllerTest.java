package com.cg.bugtracking.employee.controllerTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.bugtracking.employee.controller.EmployeeController;
import com.cg.bugtracking.employee.dto.EmployeeDto;
import com.cg.bugtracking.employee.entity.Bug;
import com.cg.bugtracking.employee.entity.Employee;
import com.cg.bugtracking.employee.service.IEmployeeService;

public class EmployeeControllerTest {
	long empId;
	@Mock
	public EmployeeDto employeeDto;

	@BeforeEach
	public void setUp() {
		MockitoAnnotations.initMocks(this);

		employeeDto.setEmpId(1);
		employeeDto.setEmpName("aravi");
		employeeDto.setEmail("aravi@gmail.com");
		employeeDto.setContactNo("8123456789");
		employeeDto.setProjectId(321);
	}

	@InjectMocks
	EmployeeController employeeController;

	@Mock
	IEmployeeService employeeService;

	@Mock
	List<EmployeeDto> employeeDtolist;
	@Mock 
	Employee employee;

	@Test
	void testAddEmployee() 
	{
		Mockito.when(employeeService.createEmployee(employeeDto)).thenReturn(employeeDto);
		assertEquals(employeeDto,employeeController.createemployee(employeeDto));
		Mockito.verify(employeeService).createEmployee(employeeDto);
	}


	@Test
	void updateEmployee() 
	{
		Mockito.when(employeeService.updateEmployee(employeeDto)).thenReturn(employeeDto);
		assertEquals(employeeDto,employeeController.updateemployee(employeeDto));
		Mockito.verify(employeeService).updateEmployee(employeeDto);
	}
	

	@Test
	void deleteEmployee() 
	{
		Mockito.when(employeeService.deleteEmployee(12)).thenReturn(employeeDto);
		assertEquals(employeeDto,employeeController.deleteemployee(12));
		Mockito.verify(employeeService).deleteEmployee(12);

	}

	@Test
	void getEmployee() 
	{
		Mockito.when(employeeService.getEmployee(empId)).thenReturn(employeeDto);
		assertEquals(employeeDto,employeeController.getemployee(empId));
		Mockito.verify(employeeService).getEmployee(empId);
	}
	
	@Test
	void getAllEmployee() {
		Mockito.when(employeeService.getAllEmployees()).thenReturn(employeeDtolist);
		assertEquals(employeeDtolist,employeeController.allemployees());
		Mockito.verify(employeeService).getAllEmployees();
	}


}

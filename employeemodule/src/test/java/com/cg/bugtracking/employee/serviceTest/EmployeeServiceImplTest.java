package com.cg.bugtracking.employee.serviceTest;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.times;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.cg.bugtracking.employee.dto.EmployeeDto;
import com.cg.bugtracking.employee.entity.Bug;
import com.cg.bugtracking.employee.entity.Employee;
import com.cg.bugtracking.employee.mapper.EmployeeMapper;
import com.cg.bugtracking.employee.repository.IEmployeeRepository;
import com.cg.bugtracking.employee.service.EmployeeServiceImpl;

class EmployeeServiceImplTest {

	@Mock
	IEmployeeRepository er;
	
	@InjectMocks
	EmployeeServiceImpl esi;
	
	@Mock
	EmployeeDto employeeDto;
	
	@Mock
	Employee employee;
	
	@Mock
	List<EmployeeDto> employeeDtoList;
	
	
	@Mock
	List<Employee> employee1;
	
	
	@BeforeEach
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		
		employeeDto.setEmpId(1);
		employeeDto.setEmpName("aravi");
		employeeDto.setEmail("aravi@gmail.com");
		employeeDto.setContactNo("8123456789");
		employeeDto.setProjectId(321);
		
		Employee employee=EmployeeMapper.toEmployee(employeeDto);
		System.out.println(employee);
		}
	

	
	@Test
	void testAddBug() {
		Mockito.when(er.save(any(Employee.class))).thenReturn(employee);
		EmployeeDto employeeDto1=EmployeeMapper.toEmployeeDto(employee);
		EmployeeDto employeeDto2=esi.createEmployee(employeeDto1);
		assertEquals(employeeDto2.getEmpId(),employeeDto2.getEmpId());
		Mockito.verify(er,atLeast(1)).save(any(Employee.class));
	}
	 
	@Test
	void testupdateBug() {
			Mockito.when(er.save(any(Employee.class))).thenReturn(employee);
			EmployeeDto employeeDto1=EmployeeMapper.toEmployeeDto(employee);
			EmployeeDto employeeDto2=esi.updateEmployee(employeeDto1);
			assertEquals(employeeDto2.getEmpId(),employeeDto2.getEmpId());
			Mockito.verify(er,atLeast(1)).save(any(Employee.class));
	}
	
	@Test
    void testbugById() {
		 Mockito.when(er.findById(12l)).thenReturn(Optional.of(employee));
		 EmployeeDto employeeDto=EmployeeMapper.toEmployeeDto(employee);
		 assertEquals(employeeDto.getEmpId(),esi.getEmployee(12l).getEmpId());
		 Mockito.verify(er,times(1)).findById(12l);
    }
	
	@Test
	void testallemployees() {
		Mockito.when(er.findAll()).thenReturn(employee1);
		List<EmployeeDto> employeeDtoList=EmployeeMapper.toEmployeeDtoList(employee1);
		assertEquals(employeeDtoList,esi.getAllEmployees());
		Mockito.verify(er,times(1)).findAll();
	}
}

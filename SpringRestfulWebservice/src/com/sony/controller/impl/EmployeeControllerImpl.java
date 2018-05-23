package com.sony.controller.impl;

import java.util.List;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.codehaus.jackson.map.ObjectMapper;

import com.sony.controller.EmployeeController;
import com.sony.entities.Employee;
import com.sony.service.EmployeeService;

import net.minidev.json.JSONObject;

public class EmployeeControllerImpl implements EmployeeController{
	
	ObjectMapper JSON_MAPPER = new ObjectMapper();
	String result = null;
	
	@Override
	public Response findEmployeeById(int empId) {
		// TODO Auto-generated method stub
		System.out.println("In findEmployeeById(int empId)");
		EmployeeService employeeService = new EmployeeService();
		Employee employee = employeeService.findEmployeeById(empId);
		
		JSONObject object = new JSONObject();
		
		try{
			object.put("Employee", employee);
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return Response.status(Status.EXPECTATION_FAILED).entity(e.getMessage()).type(MediaType.APPLICATION_JSON).build();
			
		}
		return Response.status(Status.OK).entity(object).type(MediaType.APPLICATION_JSON).build();
	}
	@Override
	public Response persistEmployee(Employee employee) {
		// TODO Auto-generated method stub
		System.out.println("In persistEmployee(Employee employee)");
		EmployeeService employeeService = new EmployeeService();
		employeeService.persistEmployee(employee);
		
		JSONObject object = new JSONObject();
		return Response.status(Status.OK).entity(object).type(MediaType.APPLICATION_JSON).build();
	}
	@Override
	public Response updateEmployeeSalaryById(int empId, double empSalary) {
		// TODO Auto-generated method stub
		System.out.println("In updateEmployeeSalaryById(int empId, double empSalary)");
		EmployeeService employeeService = new EmployeeService();
		employeeService.updateEmployeeSalaryById(empId, empSalary);
		
		JSONObject object = new JSONObject();
		return Response.status(Status.OK).entity(object).type(MediaType.APPLICATION_JSON).build();
	}
	@Override
	public Response removeEmployee(int empId) {
		// TODO Auto-generated method stub
		System.out.println("In removeEmployee(int empId)");
		EmployeeService employeeService = new EmployeeService();
		employeeService.removeEmployee(empId);
		
		JSONObject object = new JSONObject();
		return Response.status(Status.OK).entity(object).type(MediaType.APPLICATION_JSON).build();
	}
	@Override
	public Response getAllEmployees() {
		// TODO Auto-generated method stub
		
		System.out.println("In getAllEmployees()");
		EmployeeService employeeService = new EmployeeService();
		List<Employee> employees = employeeService.getAllEmployees();
		
		JSONObject object = new JSONObject();
		try{
			object.put("Employees", employees);
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return Response.status(Status.EXPECTATION_FAILED).entity(e.getMessage()).type(MediaType.APPLICATION_JSON).build();
			
		}
		
		System.out.println("Exit getVehicles()");
		return Response.status(Status.OK).entity(object).type(MediaType.APPLICATION_JSON).build();
		
	}
	
	

}

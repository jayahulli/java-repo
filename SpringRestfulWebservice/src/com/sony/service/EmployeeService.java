package com.sony.service;

import java.sql.SQLException;
import java.util.List;

import com.sony.dao.EmployeeDAO;
import com.sony.entities.Employee;
import com.sony.helper.FactoryEmployeeDAO;

public class EmployeeService {
	
	public List<Employee> getAllEmployees(){
		EmployeeDAO employeeDAO = FactoryEmployeeDAO.createEmployeeDAO();
		List<Employee> employees = null;
		try {
			employees = employeeDAO.getAllEmployees();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return employees;
	}
	
	public Employee findEmployeeById(int empId){
		EmployeeDAO employeeDAO = FactoryEmployeeDAO.createEmployeeDAO();
		Employee employee = null;
		try {
			employeeDAO.findEmployeeById(empId);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return employee;
	}
	
	public boolean persistEmployee(Employee employee){
		EmployeeDAO employeeDAO = FactoryEmployeeDAO.createEmployeeDAO();
		boolean flag = false;
		try {
			flag = employeeDAO.persistEmployee(employee);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}
	
	public boolean updateEmployeeSalaryById(int empId , double empSalary){
		EmployeeDAO employeeDAO = FactoryEmployeeDAO.createEmployeeDAO();
		boolean flag = false;
		try {
			flag = employeeDAO.updateEmployeeSalaryById(empId, empSalary);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}
	
	public boolean removeEmployee(int empId){
		EmployeeDAO employeeDAO = FactoryEmployeeDAO.createEmployeeDAO();
		boolean flag = false;
		try {
			flag = employeeDAO.removeEmployee(empId);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}
}

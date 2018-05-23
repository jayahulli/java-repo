package com.sony.helper;

import com.sony.dao.EmployeeDAO;
import com.sony.dao.MySQLEmployeeDAOImpl;

public class FactoryEmployeeDAO {
	
	public static EmployeeDAO createEmployeeDAO(){
		EmployeeDAO employeeDAO = null;
		employeeDAO = new MySQLEmployeeDAOImpl();
		return employeeDAO;
	}

}

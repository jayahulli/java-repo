package com.sony.controller;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.sony.entities.Employee;

@Path("/employee")
public interface EmployeeController {
	
	@GET
	@Path("/findemployeebyid/{empId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response findEmployeeById(@PathParam("empId") int empId);
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/persistemployee")
	public Response persistEmployee(Employee employee);
	
	@PUT
	@Path("updateemployeesalarybyid")
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateEmployeeSalaryById(@QueryParam("empId") int empId , @QueryParam("empSalary") double empSalary);
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/removeemplyee/{empId}")
	public Response removeEmployee(@PathParam("empId") int empId);
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllEmployees();
	
}

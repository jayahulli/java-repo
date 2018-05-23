package com.web.controller.impl;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.List;
import java.util.Optional;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.UriInfo;

import org.codehaus.jackson.map.ObjectMapper;

import com.web.controller.VehicleController;
import com.web.data.Vehicle;
import com.web.data.VehicleStore;

import net.minidev.json.JSONObject;

public class VehicleControllerImpl implements VehicleController{
	
	ObjectMapper JSON_MAPPER = new ObjectMapper();
	String result = null;

	@Override
	public Response getVehicles() {
		// TODO Auto-generated method stub
		System.out.println("In getVehicles()");
		VehicleStore vehicleStore = VehicleStore.getStoreInstance();
		List<Vehicle> listOfVehicles = vehicleStore.createVehicleList();
		
		JSONObject object = new JSONObject();
		try{
			object.put("Vehicles", listOfVehicles);
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return Response.status(Status.EXPECTATION_FAILED).entity(e.getMessage()).type(MediaType.APPLICATION_JSON).build();
			
		}
		
		System.out.println("Exit getVehicles()");
		return Response.status(Status.OK).entity(object).type(MediaType.APPLICATION_JSON).build();
	}

	@Override
	public Response getVehicleById(int id) {
		// TODO Auto-generated method stub
		System.out.println("In getVehicleById(int id)");
		VehicleStore vehicleStore = VehicleStore.getStoreInstance();
		List<Vehicle> listOfVehicles = vehicleStore.getVehicleList();
		
		JSONObject object = new JSONObject();
		
		Optional<Vehicle> vehicle = listOfVehicles.stream().filter(localvehicle -> id==localvehicle.getId()).findFirst();
		
		if(vehicle.isPresent()){
			object.put("Vehicle", vehicle.get());
			return Response.status(Status.OK).entity(object).type(MediaType.APPLICATION_JSON).build();
		}
		
		return Response.status(Status.EXPECTATION_FAILED).entity("No Data Found").type(MediaType.APPLICATION_JSON).build();
	}

	@Override
	public Response getVehicleById(UriInfo info, int id, int id2) {
		// TODO Auto-generated method stub
		System.out.println("In getVehicleById(UriInfo info, int id, int id2)");
		System.out.println("Id :: "+id);
		System.out.println("Id2 :: "+id2);
		
		MultivaluedMap<String, String> parameters = info.getQueryParameters();
		String userId = parameters.getFirst("user");
		String srvcURL = info.getRequestUri().toString();
		System.out.println("srvcURL :: "+srvcURL);
		VehicleStore vehicleStore = VehicleStore.getStoreInstance();
		List<Vehicle> listOfVehicles = vehicleStore.getVehicleList();
		
		JSONObject object = new JSONObject();
		//boolean vehicleFound = false;
		
		Optional<Vehicle> vehicle = listOfVehicles.stream().filter(l_vehicle ->  (l_vehicle.getId() == id || l_vehicle.getId() == id2)).findFirst();
		
		if(vehicle.isPresent()){
			object.put("Vehicle"+vehicle.get().getId(), vehicle.get());
			return Response.status(Status.OK).entity(object).type(MediaType.APPLICATION_JSON).build();
		}
		return Response.status(Status.EXPECTATION_FAILED).entity("No Data Found").type(MediaType.APPLICATION_JSON).build();
	}

	@Override
	public Response getVehicleById(UriInfo info, int id, String zone, String user) {
		// TODO Auto-generated method stub
		System.out.println("In getVehicleById(UriInfo info, int id, String zone, String user)");
		System.out.println("id :: "+id);
		System.out.println("zone :: "+zone);
		System.out.println("user :: "+user);
		VehicleStore vehicleStore = VehicleStore.getStoreInstance();
		List<Vehicle> listVehicles = vehicleStore.getVehicleList();
		JSONObject jsonObject = new JSONObject();
		
		Optional<Vehicle> vehicle = listVehicles.stream().filter(l_vechicle -> l_vechicle.getId() == id).findFirst();
		
		if(vehicle.isPresent()){
			Vehicle newVehicle = vehicle.get();
			newVehicle.setCountryName("Vehicle From : "+zone);
			jsonObject.put("Vehicle", newVehicle);
			Writer stringWriter = new StringWriter();
			try {
				JSON_MAPPER.writeValue(stringWriter, newVehicle);
				result = JSON_MAPPER.writeValueAsString(stringWriter);
				return Response.status(Status.OK).entity(result).type(MediaType.APPLICATION_JSON).build();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
				return Response.status(Status.EXPECTATION_FAILED).entity(e.getMessage()).type(MediaType.APPLICATION_JSON).build();
			}
		}
		return Response.status(Status.EXPECTATION_FAILED).entity("No Data Found").type(MediaType.APPLICATION_JSON).build();
	}

}

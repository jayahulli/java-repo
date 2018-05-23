package com.web.data;

import java.util.ArrayList;
import java.util.List;

public class VehicleStore {
	
	static VehicleStore vehicleStore = null;
	List<Vehicle> _listOfVehicles = null;
	
	public VehicleStore() {
		super();
		this._listOfVehicles = createVehicleList();
	}
	
	public static VehicleStore getStoreInstance(){
		if(vehicleStore == null){
			vehicleStore = new VehicleStore();
		}
		return vehicleStore;
	}
	
	public void addVehicle(Vehicle vehicle){
		_listOfVehicles.add(vehicle);
	}
	
	public List<Vehicle> getVehicleList(){
		return _listOfVehicles;
	}

	public List<Vehicle> createVehicleList(){
		System.out.println("Creating Vehicle List");
		Vehicle suzukiVehicle=new Vehicle(1, "Swif"); 
		Vehicle bmwVehicle=new Vehicle(4, "BMW"); 
		Vehicle volvoVehicle=new Vehicle(3, "Volvo"); 
		Vehicle jeepVehicle=new Vehicle(2, "Jeep");
		
		List<Vehicle> listOfVehicle = new ArrayList<Vehicle>();
		listOfVehicle.add(suzukiVehicle);
		listOfVehicle.add(bmwVehicle);
		listOfVehicle.add(volvoVehicle);
		listOfVehicle.add(jeepVehicle);
		
		return listOfVehicle;
	}
}

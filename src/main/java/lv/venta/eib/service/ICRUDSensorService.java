package lv.venta.eib.service;

import java.util.ArrayList;

import lv.venta.eib.model.MOSFET;
import lv.venta.eib.model.Sensor;

public interface ICRUDSensorService {
	
	public boolean addSensor(Sensor sensor);
	
	public ArrayList<Sensor> showAllSensor();
	
	public Sensor selectById(int id);
	
	public boolean editById(int id, Sensor sensor);

	public ArrayList<Sensor> findSensorBySearchTerm(String searchterm);
}

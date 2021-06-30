package lv.venta.eib.service;

import java.util.ArrayList;

import lv.venta.eib.model.Capacitor;

public interface ICRUDCapacitorService {
	
	public boolean addCapacitor(Capacitor capacitor);
	
	public ArrayList<Capacitor> showAllCapacitor();
	
	public Capacitor selectById(int id);
	
	public boolean editById(int id, Capacitor capacitor);
	
	public ArrayList<Capacitor> findCapacitorBySearchTerm(String searchterm);
}

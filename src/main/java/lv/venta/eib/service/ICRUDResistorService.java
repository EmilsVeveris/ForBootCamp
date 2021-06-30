package lv.venta.eib.service;

import java.util.ArrayList;

import lv.venta.eib.model.MOSFET;
import lv.venta.eib.model.Resistor;

public interface ICRUDResistorService {
	
	public boolean addResistor(Resistor resistor);
	
	public ArrayList<Resistor> showAllResistor();
	
	public Resistor selectById(int id);
	
	public boolean editById(int id, Resistor resistor);
	
	public ArrayList<Resistor> findResistorBySearchTerm(String searchterm);
}

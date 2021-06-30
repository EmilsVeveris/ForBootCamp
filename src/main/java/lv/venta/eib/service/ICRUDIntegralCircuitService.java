package lv.venta.eib.service;

import java.util.ArrayList;

import lv.venta.eib.model.Capacitor;
import lv.venta.eib.model.IntegralCircuit;

public interface ICRUDIntegralCircuitService {

	
	public boolean addIntegralCircuit(IntegralCircuit integralCircuit);
	
	public ArrayList<IntegralCircuit> showAllIntegralCircuit();
	
	public IntegralCircuit selectById(int id);
	
	public boolean editById(int id, IntegralCircuit integralCircuit);

	public ArrayList<IntegralCircuit> findICBySearchTerm(String searchterm);
}

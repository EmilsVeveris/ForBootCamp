package lv.venta.eib.service;

import java.util.ArrayList;

import lv.venta.eib.model.Capacitor;
import lv.venta.eib.model.MOSFET;

public interface ICRUDMOSFETService {
	
	public boolean addMOSFET(MOSFET mosfet);
	
	public ArrayList<MOSFET> showAllMOSFET();
	
	public MOSFET selectById(int id);
	
	public boolean editById(int id, MOSFET mosfet);
	
	public ArrayList<MOSFET> findMOSFETBySearchTerm(String searchterm);
}

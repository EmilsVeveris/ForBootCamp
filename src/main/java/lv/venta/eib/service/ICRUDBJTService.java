package lv.venta.eib.service;

import java.util.ArrayList;
import lv.venta.eib.model.BJT;
import lv.venta.eib.model.Capacitor;


public interface ICRUDBJTService {
	
	public boolean addBJT(BJT bjt);
	
	public ArrayList<BJT> showAllBJT();

	public BJT selectById(int id);
	
	public boolean editById(int id, BJT bjt);
	
	public ArrayList<BJT> findBJTBySearchTerm(String searchterm);
}

package lv.venta.eib.service;

import java.util.ArrayList;

import lv.venta.eib.model.Capacitor;
import lv.venta.eib.model.MicroController;

public interface ICRUDMicroControllerService {
	
	public boolean addMicroController(MicroController microController);
	
	public ArrayList<MicroController> showAllMicroController();
	
	public MicroController selectById(int id);
	
	public boolean editById(int id, MicroController microController);
	
	public ArrayList<MicroController> findMCBySearchTerm(String searchterm);
}

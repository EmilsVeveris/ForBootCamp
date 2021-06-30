package lv.venta.eib.service;

import java.util.ArrayList;

import lv.venta.eib.model.Capacitor;
import lv.venta.eib.model.Inductor;

public interface ICRUDInductorService {

	public boolean addInductor(Inductor inductor);
	
	public ArrayList<Inductor> showAllInductor();

	public Inductor selectById(int id);

	public boolean editById(int id, Inductor inductor);

	public ArrayList<Inductor> findInductorBySearchTerm(String searchterm);
}

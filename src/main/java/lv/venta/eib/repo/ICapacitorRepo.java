package lv.venta.eib.repo;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;

import lv.venta.eib.model.Capacitor;

public interface ICapacitorRepo extends CrudRepository<Capacitor, Integer> {

	ArrayList<Capacitor> findByComponentId(String componentId);
	
	ArrayList<Capacitor> findByComponentIdContainingIgnoreCase(String componentId);

	ArrayList<Capacitor> findByDescriptionContainingIgnoreCase(String description);
	
	ArrayList<Capacitor> findByCasestyleContainingIgnoreCase(String caseStyle);
	
	ArrayList<Capacitor> findByCapacitance(float capacitance);
	
}

package lv.venta.eib.repo;
import java.util.ArrayList;


import org.springframework.data.repository.CrudRepository;

import lv.venta.eib.model.Resistor;
public interface IResistorRepo extends CrudRepository<Resistor, Integer> {

	ArrayList<Resistor> findByComponentId(String componentId);

	ArrayList<Resistor> findByComponentIdContainingIgnoreCase(String componentId);
	
	ArrayList<Resistor> findByCasestyleContainingIgnoreCase(String caseStyle);
	
	ArrayList<Resistor> findByDescriptionContainingIgnoreCase(String description);

	ArrayList<Resistor> findByResistance(float resistance);
	
}

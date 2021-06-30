package lv.venta.eib.repo;
import java.util.ArrayList;


import org.springframework.data.repository.CrudRepository;

import lv.venta.eib.model.Sensor;
public interface ISensorRepo extends CrudRepository<Sensor, Integer> {

	ArrayList<Sensor> findByComponentId(String componentId);

	ArrayList<Sensor> findByComponentIdContainingIgnoreCase(String componentId);
	
	ArrayList<Sensor> findByCasestyleContainingIgnoreCase(String caseStyle);
	
	ArrayList<Sensor> findByDescriptionContainingIgnoreCase(String description);
}

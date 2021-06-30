package lv.venta.eib.repo;
import java.util.ArrayList;


import org.springframework.data.repository.CrudRepository;

import lv.venta.eib.model.MOSFET;
public interface IMOSFETRepo extends CrudRepository<MOSFET, Integer> {

	ArrayList<MOSFET> findByComponentId(String componentId);

	ArrayList<MOSFET> findByComponentIdContainingIgnoreCase(String componentId);
	
	ArrayList<MOSFET> findByCasestyleContainingIgnoreCase(String caseStyle);
	
	ArrayList<MOSFET> findByDescriptionContainingIgnoreCase(String description);
}

package lv.venta.eib.repo;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;
import lv.venta.eib.model.BJT;

public interface IBJTRepo extends CrudRepository<BJT, Integer> {

	ArrayList<BJT> findByComponentId(String componentId);
	
	ArrayList<BJT> findByComponentIdContainingIgnoreCase(String componentId);
	
	ArrayList<BJT> findByCasestyleContainingIgnoreCase(String caseStyle);
	
	ArrayList<BJT> findByDescriptionContainingIgnoreCase(String description);
	
	ArrayList<BJT> findByBjtTypeContainingIgnoreCase(String bjtType);

}

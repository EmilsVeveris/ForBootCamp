package lv.venta.eib.repo;
import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;

import lv.venta.eib.model.MicroController;
public interface IMicroControllerRepo extends CrudRepository<MicroController, Integer> {

	ArrayList<MicroController> findByComponentId(String componentId);
	
	ArrayList<MicroController> findByComponentIdContainingIgnoreCase(String componentId);

	ArrayList<MicroController> findByCasestyleContainingIgnoreCase(String caseStyle);
	
	ArrayList<MicroController> findByDescriptionContainingIgnoreCase(String description);
}

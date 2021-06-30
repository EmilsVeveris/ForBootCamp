package lv.venta.eib.repo;
import java.util.ArrayList;


import org.springframework.data.repository.CrudRepository;


import lv.venta.eib.model.IntegralCircuit;
public interface IIntegralCircuitRepo extends CrudRepository<IntegralCircuit, Integer> {
	
	ArrayList<IntegralCircuit> findByComponentId(String componentId);

	ArrayList<IntegralCircuit> findByComponentIdContainingIgnoreCase(String componentId);

	ArrayList<IntegralCircuit> findByCasestyleContainingIgnoreCase(String caseStyle);
	
	ArrayList<IntegralCircuit> findByDescriptionContainingIgnoreCase(String description);

}

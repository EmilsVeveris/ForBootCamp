package lv.venta.eib.repo;
import java.util.ArrayList;


import org.springframework.data.repository.CrudRepository;


import lv.venta.eib.model.Inductor;
public interface IInductorRepo  extends CrudRepository<Inductor, Integer> {

	ArrayList<Inductor> findByComponentId(String componentId);
	
	ArrayList<Inductor> findByComponentIdContainingIgnoreCase(String componentId);

	ArrayList<Inductor> findByCasestyleContainingIgnoreCase(String casestyle);
	
	ArrayList<Inductor> findByDescriptionContainingIgnoreCase(String description);
	
	ArrayList<Inductor> findByInductance(float inductance);
}

package lv.venta.eib.serviceImpl;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lv.venta.eib.model.IntegralCircuit;
import lv.venta.eib.model.MicroController;
import lv.venta.eib.repo.IMicroControllerRepo;
import lv.venta.eib.service.ICRUDMicroControllerService;

@Service
public class CRUDMicroControllerServiceImpl implements ICRUDMicroControllerService {

	@Autowired
	IMicroControllerRepo microControllerRepo;
	@Override
	public boolean addMicroController(MicroController microController) {
		ArrayList<MicroController> comp = microControllerRepo.findByComponentId(microController.getComponentId());
		if (comp.isEmpty() == true)
		{
			microControllerRepo.save(microController);
			return true;
		}
		return false;
	}

	@Override
	public ArrayList<MicroController> showAllMicroController() {
		return (ArrayList<MicroController>) microControllerRepo.findAll();
	}

	@Override
	public MicroController selectById(int id) {
		MicroController comp = microControllerRepo.findById(id).get();
		if (comp != null)
			return comp;
		else
			return new MicroController();
	}

	@Override
	public boolean editById(int id, MicroController microController) {
		
		MicroController st = microControllerRepo.findById(id).get();
		if(st != null)
		{
			//component values
			System.out.println("Editing the component");
			st.setComponentId(microController.getComponentId());
			st.setCount(microController.getCount());
			st.setCasestyle(microController.getCasestyle());
			st.setCasetype(microController.getCasetype());

			st.setDatasheet(microController.getDatasheet());
			st.setDescription(microController.getDescription());
			st.setRoom(microController.getRoom());
			st.setTolerance(microController.getTolerance());
			
			//Specific values
			st.setSupplyVoltage(microController.getSupplyVoltage());

			microControllerRepo.save(st);
			return true;
		}

		return false;
	}

	public ArrayList<MicroController> findMCBySearchTerm(String searchterm) {
		Set<MicroController> foundComponents = new LinkedHashSet<>(microControllerRepo.findByDescriptionContainingIgnoreCase(searchterm));
		foundComponents.addAll(microControllerRepo.findByCasestyleContainingIgnoreCase(searchterm));
		foundComponents.addAll(microControllerRepo.findByComponentIdContainingIgnoreCase(searchterm));
		ArrayList<MicroController> results = new ArrayList<>(foundComponents);
		return results;
	}
	
}

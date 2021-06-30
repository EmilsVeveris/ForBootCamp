package lv.venta.eib.serviceImpl;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lv.venta.eib.model.Inductor;
import lv.venta.eib.model.IntegralCircuit;
import lv.venta.eib.repo.IIntegralCircuitRepo;
import lv.venta.eib.service.ICRUDIntegralCircuitService;

@Service
public class CRUDIntegralCircuitServiceImpl implements ICRUDIntegralCircuitService{
	@Autowired
	IIntegralCircuitRepo integralCircuitRepo;
	@Override
	public boolean addIntegralCircuit(IntegralCircuit integralCircuit) {
		ArrayList<IntegralCircuit> comp = integralCircuitRepo.findByComponentId(integralCircuit.getComponentId());
		if (comp.isEmpty() == true)
		{
			integralCircuitRepo.save(integralCircuit);
			return true;
		}
		return false;
	}

	@Override
	public ArrayList<IntegralCircuit> showAllIntegralCircuit() {
		return (ArrayList<IntegralCircuit>) integralCircuitRepo.findAll();
	}

	@Override
	public IntegralCircuit selectById(int id) {
		IntegralCircuit comp = integralCircuitRepo.findById(id).get();
		if (comp != null)
			return comp;
		else
			return new IntegralCircuit();
	}

	@Override
	public boolean editById(int id, IntegralCircuit integralCircuit) {
		
		IntegralCircuit st = integralCircuitRepo.findById(id).get();
		if(st != null)
		{
			//component values
			System.out.println("Editing the component");
			st.setComponentId(integralCircuit.getComponentId());
			st.setCount(integralCircuit.getCount());
			st.setCasestyle(integralCircuit.getCasestyle());
			st.setCasetype(integralCircuit.getCasetype());

			st.setDatasheet(integralCircuit.getDatasheet());
			st.setDescription(integralCircuit.getDescription());
			st.setRoom(integralCircuit.getRoom());
			st.setTolerance(integralCircuit.getTolerance());
			
			//Specific values
			st.setSupplyVoltage(integralCircuit.getSupplyVoltage());
			integralCircuitRepo.save(st);
			return true;
		}

		return false;
	}
	
	public ArrayList<IntegralCircuit> findICBySearchTerm(String searchterm) {
		Set<IntegralCircuit> foundComponents = new LinkedHashSet<>(integralCircuitRepo.findByDescriptionContainingIgnoreCase(searchterm));
		foundComponents.addAll(integralCircuitRepo.findByCasestyleContainingIgnoreCase(searchterm));
		foundComponents.addAll(integralCircuitRepo.findByComponentIdContainingIgnoreCase(searchterm));
		ArrayList<IntegralCircuit> results = new ArrayList<>(foundComponents);
		return results;
	}

}
